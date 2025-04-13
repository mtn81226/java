import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.concurrent.*;
import org.jsoup.Jsoup;

public class DownloadAndProcessContent {

    private static final String[] URLS = {
        "https://example.com/article1",
        "https://example.com/article2",
        "https://example.com/article3",
        "https://example.com/article4",
        "https://example.com/article5"
    };

    private static final String OUTPUT_DIRECTORY = "path/to/output/directory";
    private static final String MERGED_OUTPUT_FILE = "path/to/output/merged_output.txt";

    public static void main(String[] args) {
        // Tạo thư mục nếu chưa tồn tại
        File directory = new File(OUTPUT_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        ExecutorService downloadExecutor = Executors.newFixedThreadPool(URLS.length);

        // Tải nội dung từ các URL
        for (int i = 0; i < URLS.length; i++) {
            final int index = i;
            downloadExecutor.submit(() -> downloadContent(URLS[index], OUTPUT_DIRECTORY + File.separator + "file" + (index + 1) + ".txt"));
        }

        downloadExecutor.shutdown();
        try {
            downloadExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService processExecutor = Executors.newFixedThreadPool(URLS.length);
        StringBuilder mergedContent = new StringBuilder();

        // Đọc nội dung từ các file đã tải về và loại bỏ các ký tự HTML không cần thiết
        File[] filesList = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (filesList != null) {
            for (File file : filesList) {
                processExecutor.submit(() -> {
                    String content = readFile(file);
                    String cleanedContent = removeHtmlTags(content);
                    synchronized (mergedContent) {
                        mergedContent.append(cleanedContent).append("\n");
                    }
                });
            }
        }

        processExecutor.shutdown();
        try {
            processExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        writeFile(MERGED_OUTPUT_FILE, mergedContent.toString());
        System.out.println("Nội dung đã được gộp vào file: " + MERGED_OUTPUT_FILE);
    }

    private static void downloadContent(String urlString, String outputFileName) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(urlString).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(outputFileName)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("Downloaded content from " + urlString + " to " + outputFileName);
        } catch (IOException e) {
            System.err.println("Failed to download content from " + urlString);
            e.printStackTrace();
        }
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
        return Jsoup.parse(content).text();
    }

    private static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}