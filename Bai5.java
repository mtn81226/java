import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class Bai5 {

    private static final String DIRECTORY_PATH = "C:\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\JAVA";
    private static final String OUTPUT_FILE = "C:\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\JAVA\\merged_output.txt";

    public static void main(String[] args) {
        
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Thư mục không tồn tại hoặc không phải là thư mục hợp lệ.");
            return;
        }

        
        File[] filesList = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (filesList == null || filesList.length == 0) {
            System.out.println("Không có file văn bản nào trong thư mục.");
            return;
        }

      
        ExecutorService executor = Executors.newFixedThreadPool(filesList.length);
        StringBuilder mergedContent = new StringBuilder();

       
        for (File file : filesList) {
            executor.submit(() -> {
                try {
                    String content = new String(Files.readAllBytes(file.toPath()));
                    synchronized (mergedContent) {
                        mergedContent.append(content).append("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

       
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            writer.write(mergedContent.toString());
            System.out.println("Nội dung đã được ghi vào file: " + OUTPUT_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}