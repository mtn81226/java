import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class bai4GhiDanhSachSonguyenvaofile {
    public static void main(String[] args) {
        String filePath = "numbers.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            int[] numbers = {10, 20, 30, 40, 50};
            for (int number : numbers) {
                dos.writeInt(number);
            }
            System.out.println("Ghi danh sách số nguyên vào file thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            System.out.println("Các số nguyên đọc từ file:");
            while (dis.available() > 0) {
                int number = dis.readInt();
                System.out.println(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}