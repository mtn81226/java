import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DownloadFilesFromURLs {

    private static final String[] URLS = {
        "https://example.com/article1",
        "https://example.com/article2",
        "https://example.com/article3",
        "https://example.com/article4",
        "https://example.com/article5"
    };

    private static final String OUTPUT_DIR = "output";

    public static void main(String[] args) {
        // Tạo thư mục output nếu chưa tồn tại
        File outputDir = new File(OUTPUT_DIR);
        if (!outputDir.exists()) {
            outputDir.mkdir();
        }

        // Sử dụng ExecutorService để quản lý các thread
        ExecutorService executor = Executors.newFixedThreadPool(URLS.length);

        // Tải nội dung từ các URL và lưu vào các file riêng biệt
        for (int i = 0; i < URLS.length; i++) {
            final int index = i;
            executor.submit(() -> {
                try {
                    downloadFile(URLS[index], OUTPUT_DIR + "/file" + (index + 1) + ".txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        // Đợi cho tất cả các thread tải file hoàn thành
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Download completed.");
    }

    private static void downloadFile(String urlString, String filePath) throws IOException {
        try (InputStream in = new URL(urlString).openStream()) {
            Files.copy(in, Paths.get(filePath));
            System.out.println("Downloaded: " + filePath);
        }
    }
}