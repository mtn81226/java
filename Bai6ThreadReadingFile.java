import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class Bai6ThreadReadingFile {

    private static final String INPUT_FILE = "C:\\Users\\Ngan\\Documents\\Zalo Received Files\\input.txt";
    private static final String OUTPUT_FILE = "C:\\Users\\Ngan\\Documents\\Zalo Received Files\\output.txt";
    private static final int CHUNK_SIZE = 1024 * 1024; // 1MB

    public static void main(String[] args) {
        File inputFile = new File(INPUT_FILE);
        long fileSize = inputFile.length();
        int numChunks = (int) Math.ceil((double) fileSize / CHUNK_SIZE);

        ExecutorService executor = Executors.newFixedThreadPool(numChunks);
        StringBuilder[] results = new StringBuilder[numChunks];

        for (int i = 0; i < numChunks; i++) {
            final int chunkIndex = i;
            results[chunkIndex] = new StringBuilder();

            executor.submit(() -> {
                try (RandomAccessFile raf = new RandomAccessFile(inputFile, "r")) {
                    long start = chunkIndex * CHUNK_SIZE;
                    long end = Math.min(start + CHUNK_SIZE, fileSize);
                    raf.seek(start);

                    byte[] buffer = new byte[(int) (end - start)];
                    raf.read(buffer);
                    results[chunkIndex].append(new String(buffer));
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
            for (StringBuilder result : results) {
                writer.write(result.toString());
            }
            System.out.println("Nội dung đã được ghi vào file: " + OUTPUT_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}