import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class KeywordSearchMultiThread {

    private static final String DIRECTORY_PATH = "C:\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\JAVA";
    private static final String KEYWORD = "out";

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
        Future<Integer>[] results = new Future[filesList.length];

        for (int i = 0; i < filesList.length; i++) {
            final File file = filesList[i];
            results[i] = executor.submit(() -> countKeywordOccurrences(file, KEYWORD));
        }

        executor.shutdown();

        int totalOccurrences = 0;
        for (Future<Integer> result : results) {
            try {
                totalOccurrences += result.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Tổng số lần xuất hiện của từ khóa \"" + KEYWORD + "\": " + totalOccurrences);
    }

    private static int countKeywordOccurrences(File file, String keyword) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countOccurrences(line, keyword);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private static int countOccurrences(String line, String keyword) {
        int count = 0;
        int index = 0;
        while ((index = line.indexOf(keyword, index)) != -1) {
            count++;
            index += keyword.length();
        }
        return count;
    }
}