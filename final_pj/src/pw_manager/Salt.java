package pw_manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

import enums.FilePath;

public class Salt {
	public Salt() throws IOException {
		String saltPath = FilePath.SALT.getPath();
		File saltFile = new File(saltPath);
		
		if (!saltFile.exists()) {
			saltFile.createNewFile();
	    	saltGenerator();
		}
	}
	
	private static void saltGenerator() throws IOException {
		//1. Random, byte 객체 생성
		SecureRandom  r = new SecureRandom ();
		byte[] salt = new byte[20];
		
		//2. 난수 생성
		r.nextBytes(salt);
		
		saveHashToFile(salt, FilePath.SALT.getPath());
	}
	
	private static void saveHashToFile(byte[] hashValue, String filePath) throws IOException {
		try (FileOutputStream out = new FileOutputStream(filePath)) {
            out.write(hashValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}
}
