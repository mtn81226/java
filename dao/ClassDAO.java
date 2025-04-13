package dao;

import model.Class;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
  
    public void addClass(String description, int numberOfCredits) throws SQLException {
        String query = "INSERT INTO class (description, numberOfCredits) VALUES (?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, description);
            stmt.setInt(2, numberOfCredits);
            stmt.executeUpdate();
            System.out.println("Thêm lớp học thành công!");
        }
    }

   
    public List<Class> getAllClasses() throws SQLException {
        List<Class> classes = new ArrayList<>();
        String query = "SELECT * FROM class";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                classes.add(new Class(rs.getInt("classID"),
                                      rs.getString("description"),
                                      rs.getInt("numberOfCredits")));
            }
        }
        return classes;
    }
}
