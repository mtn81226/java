import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bai1DocGhiTuFile {
public static void main(String[] args) {
	String inputFile = "C:\\Users\\Ngan\\Documents\\Zalo Received Files\\input.txt";
	String outputFile = "C:\\Users\\Ngan\\Documents\\Zalo Received Files\\output.txt";
	try(FileInputStream fis = new FileInputStream(inputFile);
			FileOutputStream fos = new FileOutputStream(outputFile)){
		byte[] buffer = new byte[1024];
		int bytesRead;
		while ((bytesRead = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, bytesRead);
		}
		System.out.println("File copied successfully!");
		
	} catch(IOException e) {
		e.printStackTrace();
	}
			
}
}
