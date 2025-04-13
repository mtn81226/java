package dao;

import java.sql.*;

import util.DatabaseConnection;

public class LearnDAO {
    public void enrollStudent(int studentID, int classID) throws SQLException {
        String query = "INSERT INTO learn (studentID, classID) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, studentID);
            stmt.setInt(2, classID);
            stmt.executeUpdate();
            System.out.println("Đã thêm sinh viên vào lớp thành công!");
        }
    }

    public void listStudentsInClass(int classID) throws SQLException {
        String query = "SELECT s.studentID, s.name, s.email FROM student s " +
                       "JOIN learn l ON s.studentID = l.studentID WHERE l.classID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, classID);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Danh sách sinh viên trong lớp " + classID + ":");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Email: %s%n",
                        rs.getInt("studentID"),
                        rs.getString("name"),
                        rs.getString("email"));
            }
        }
    }
}
