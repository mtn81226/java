package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DatabaseConnection;

public class StudentDAO {

    
    private String generateEmail(String name) {
        String[] words = name.split(" ");
        String email = words[words.length - 1].toLowerCase();
        for (int i = 0; i < words.length - 1; i++) {
            email += words[i].charAt(0);
        }
        return email + "@vku.udn.vn";
    }

    public void addStudent(String name, int age, double gpa) throws SQLException {
        String email = generateEmail(name);
        String query = "INSERT INTO student (name, age, email, gpa) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, email);
            stmt.setDouble(4, gpa);
            stmt.executeUpdate();
            System.out.println("Thêm sinh viên thành công!");
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                students.add(new Student(rs.getInt("studentID"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getDouble("gpa")));
            }
        }
        return students;
    }
}
