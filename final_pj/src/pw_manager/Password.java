package pw_manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import enums.Algorithm;
import enums.FilePath;


public class Password {
	public static boolean checkPassWord(char[] pwArr){
		try {
			new Salt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		boolean ifEqual = false;
		
		byte[] salt = readFromFile(FilePath.SALT.getPath());
		byte[] result = getEncrypt(pwArr, salt);
		byte[] origin = readFromFile(FilePath.HASHED_PW.getPath());
		
		ifEqual = Arrays.equals(result, origin);
		
		return ifEqual;
	}
	
	private static byte[] getEncrypt(char[] pwArr, byte[] saltArr){
		byte[] pwSalt = null;
		String pw = new String(pwArr);
		String salt = new String(saltArr);

		try {
			MessageDigest md = MessageDigest.getInstance(Algorithm.SHA128.getAlgorithm());
			md.update((pw+salt).getBytes());
			pwSalt = md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return pwSalt;
    }
	
	private static byte[] readFromFile(String filePath) {
        byte[] fileData = null;
        
        try (FileInputStream in = new FileInputStream(filePath)) {
            fileData = in.readAllBytes();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return fileData;
    } 
}
