// 컴퓨터학과, 20190975, 신효경
package key_manager;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import enums.Algorithm;
import enums.FilePath;

public class CreateSaveSymKey {	
	public static SecretKey create(){
		KeyGenerator keyGen = null;
		
		try {
			keyGen = KeyGenerator.getInstance(Algorithm.AES.getAlgorithm());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		keyGen.init(Integer.parseInt(Algorithm.AES_LENGTH.getAlgorithm()));
		SecretKey secretKey = keyGen.generateKey();
		
		File publicFile = new File(FilePath.SK_DIRECTORY.getPath());
		if (publicFile.exists()) {
            publicFile.delete();
        }
		
		return secretKey;
	}
}
