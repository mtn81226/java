import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            CustomerDAO customerDAO = new CustomerDAO();
            OrderDAO orderDAO = new OrderDAO();
            ProductDAO productDAO = new ProductDAO();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Thêm khách hàng");
                System.out.println("2. Tạo đơn hàng");
                System.out.println("3. Xem lịch sử đơn hàng");
                System.out.println("4. Tính tổng tiền đơn hàng");
                System.out.println("5. Thêm sản phẩm");
                System.out.println("6. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên khách hàng: ");
                        String customerName = scanner.nextLine();
                        customerDAO.addCustomer(customerName);
                        System.out.println("Khách hàng đã được thêm!");
                        break;

                    case 2:
                        System.out.print("Nhập ID khách hàng: ");
                        int customerId = scanner.nextInt();
                        Map<Integer, Integer> productQuantities = new HashMap<>();
                        System.out.println("Nhập ID sản phẩm và số lượng (0 để dừng):");

                        while (true) {
                            System.out.print("ID sản phẩm: ");
                            int productId = scanner.nextInt();
                            if (productId == 0) break;
                            if (!productDAO.checkProductExists(productId)) {
                                System.out.println("Sản phẩm không tồn tại!");
                                continue;
                            }
                            System.out.print("Số lượng: ");
                            int quantity = scanner.nextInt();
                            productQuantities.put(productId, quantity);
                        }
                        orderDAO.addOrder(customerId, productQuantities);
                        break;

                    case 3:
                        System.out.print("Nhập ID khách hàng để xem lịch sử đơn hàng: ");
                        orderDAO.getOrderHistory(scanner.nextInt());
                        break;

                    case 4:
                        System.out.print("Nhập ID đơn hàng để tính tổng tiền: ");
                        System.out.println("Tổng tiền: " + orderDAO.calculateTotal(scanner.nextInt()));
                        break;

                    case 5:
                        System.out.print("Nhập tên sản phẩm: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập giá sản phẩm: ");
                        double price = scanner.nextDouble();
                        productDAO.addProduct(name, price);
                        break;

                    case 6:
                        System.out.println("Thoát chương trình.");
                        return;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
