package file_manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;


public class SaveFile {
	public static void saveHashToFile(byte[] hashValue, String filePath) {
		try (FileOutputStream out = new FileOutputStream(filePath)) {
            out.write(hashValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}
	
	public static void saveCipherDataToFile(Cipher cipher, byte[] data, String filePath) {
        try(FileOutputStream bos = new FileOutputStream(filePath);
				CipherOutputStream cos = new CipherOutputStream(bos, cipher)){
			cos.write(data);
			cos.flush();			
		} catch(IOException e) {
			e.printStackTrace();
		}
    }
	
	public static void saveKey(String path, Key key) {
		File publicFile = new File(path);
		if (!publicFile.exists()) {
            try {
            	publicFile.createNewFile();
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }	
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(key);
        } catch (IOException e) {
        	e.printStackTrace();
        }
		
	}
}
