import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		File file = new File("src/file.txt");

		if (file.exists()){
			System.out.println("the file already exists. do you want to overwrite it?(y/n)");
			Scanner sc = new Scanner(System.in);
			String a = sc.next();
			if (!a.equals("y")){
				System.out.println("you choose to not overwrite it, exiting program.");
				return;
			}
		} else {
			System.out.println("creating new file...");
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		try {
			FileWriter fileWriter = new FileWriter(file);
			LocalDateTime localDateTime = LocalDateTime.now();
			System.out.println("writing "+localDateTime+" to the file...");
			fileWriter.write(String.valueOf(localDateTime));
			fileWriter.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}