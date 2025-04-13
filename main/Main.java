package main;

import dao.ClassDAO;
import dao.LearnDAO;
import dao.StudentDAO;
import model.Class;
import model.Student;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        ClassDAO classDAO = new ClassDAO();
        LearnDAO learnDAO = new LearnDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xem danh sách sinh viên");
            System.out.println("3. Thêm lớp học");
            System.out.println("4. Xem danh sách lớp học");
            System.out.println("5. Thêm sinh viên vào lớp");
            System.out.println("6. Danh sách sinh viên trong lớp");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên sinh viên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập tuổi: ");
                        int age = scanner.nextInt();
                        System.out.print("Nhập GPA: ");
                        double gpa = scanner.nextDouble();
                        studentDAO.addStudent(name, age, gpa);
                        break;
                    case 2:
                        List<Student> students = studentDAO.getAllStudents();
                        System.out.println("Danh sách sinh viên:");
                        for (Student s : students) {
                            System.out.println(s.getStudentID() + " - " + s.getName() + " - " + s.getEmail() + " - GPA: " + s.getGpa());
                        }
                        break;
                    case 3:
                        System.out.print("Nhập mô tả lớp học: ");
                        String description = scanner.nextLine();
                        System.out.print("Nhập số tín chỉ: ");
                        int credits = scanner.nextInt();
                        classDAO.addClass(description, credits);
                        break;
                    case 4:
                        List<Class> classes = classDAO.getAllClasses();
                        System.out.println("Danh sách lớp học:");
                        for (Class c : classes) {
                            System.out.println(c.toString());
                        }
                        break;
                    case 5:
                        System.out.print("Nhập ID sinh viên: ");
                        int studentID = scanner.nextInt();
                        System.out.print("Nhập ID lớp học: ");
                        int classID = scanner.nextInt();
                        learnDAO.enrollStudent(studentID, classID);
                        break;
                    case 6:
                        System.out.print("Nhập ID lớp học: ");
                        int classId = scanner.nextInt();
                        learnDAO.listStudentsInClass(classId);
                        break;
                    case 7:
                        System.out.println("Thoát chương trình...");
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
