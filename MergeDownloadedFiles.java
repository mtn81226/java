import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MergeDownloadedFiles {

    private static final String INPUT_DIRECTORY = "C:\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\JAVA";
    private static final String OUTPUT_FILE = "C:\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\JAVA\\output.txt";

    public static void main(String[] args) {
        File directory = new File(INPUT_DIRECTORY);

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
                String content = readFile(file);
                String cleanedContent = removeHtmlTags(content);
                synchronized (mergedContent) {
                    mergedContent.append(cleanedContent).append("\n");
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        writeFile(OUTPUT_FILE, mergedContent.toString());
        System.out.println("Nội dung đã được gộp vào file: " + OUTPUT_FILE);
    }

    private static String readFile(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private static String removeHtmlTags(String content) {
        return content.replaceAll("<[^>]*>", "");
    }

    private static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}