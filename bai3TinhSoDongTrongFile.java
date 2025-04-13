import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class bai3TinhSoDongTrongFile {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\Ngan\\Documents\\Zalo Received Files\\input3.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            int lineCount = 0;
            while (br.readLine() != null) {
                lineCount++;
            }

            System.out.println("Số dòng trong file: " + lineCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}