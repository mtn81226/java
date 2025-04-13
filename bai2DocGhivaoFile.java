import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class bai2DocGhivaoFile {
    public static void main(String[] args) {
        String outputFilePath = "C:\\Users\\Ngan\\Documents\\Zalo Received Files\\output2.txt"; 

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter(outputFilePath)) {

            System.out.println("Nhập dữ liệu (gõ 'exit' để kết thúc):");

            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(line + System.lineSeparator());
            }

            System.out.println("Dữ liệu đã được lưu vào file " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}