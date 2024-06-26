package file_manager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class SendFile {
	public static void send(String from, String to) {
		Path pathFrom = Paths.get(from);
		Path pathTo = Paths.get(to);
		try {
			//파일의 경로를 바꿔서 이동시킴
			Files.move(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
		   e.printStackTrace();
		}
	}
}
