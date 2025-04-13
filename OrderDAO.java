import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class OrderDAO {
    public void addOrder(int customerId, Map<Integer, Integer> productQuantities) throws SQLException {
        String orderQuery = "INSERT INTO orders (customer_id, order_date) VALUES (?, NOW())";
        String orderItemQuery = "INSERT INTO orders_items (order_id, product_id, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement orderStmt = conn.prepareStatement(orderQuery, PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement orderItemStmt = conn.prepareStatement(orderItemQuery)) {

            conn.setAutoCommit(false);
            orderStmt.setInt(1, customerId);
            orderStmt.executeUpdate();
            ResultSet generatedKeys = orderStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                int orderId = generatedKeys.getInt(1);
                for (Map.Entry<Integer, Integer> entry : productQuantities.entrySet()) {
                    orderItemStmt.setInt(1, orderId);
                    orderItemStmt.setInt(2, entry.getKey());
                    orderItemStmt.setInt(3, entry.getValue());
                    orderItemStmt.executeUpdate();
                }
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getOrderHistory(int customerId) throws SQLException {
        String query = "SELECT o.id, o.order_date, p.name, oi.quantity, p.price FROM orders o " +
                       "JOIN orders_items oi ON o.id = oi.order_id " +
                       "JOIN product p ON oi.product_id = p.id " +
                       "WHERE o.customer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.printf("Order ID: %d | Date: %s | Product: %s | Quantity: %d | Price: %.2f\n",
                        rs.getInt("id"), rs.getString("order_date"), rs.getString("name"),
                        rs.getInt("quantity"), rs.getDouble("price"));
            }
        }
    }

    public double calculateTotal(int orderId) throws SQLException {
        String query = "SELECT SUM(p.price * oi.quantity) AS total FROM orders_items oi " +
                       "JOIN product p ON oi.product_id = p.id " +
                       "WHERE oi.order_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("total");
            }
        }
        return 0;
    }
}
