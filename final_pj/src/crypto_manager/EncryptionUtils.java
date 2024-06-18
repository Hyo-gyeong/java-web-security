package crypto_manager;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import enums.Algorithm;

public class EncryptionUtils {
	public static byte[] encryptSecretKey(SecretKey sk, PublicKey pk) {
    	byte[] byteKey = sk.getEncoded();
        Cipher cipher = null;
        byte[] result = null;
        
		try {
			cipher = Cipher.getInstance(Algorithm.RSA.getAlgorithm());
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		
        try {
			cipher.init(Cipher.ENCRYPT_MODE, pk);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
        
		try {
			result = cipher.doFinal(byteKey);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		
        return result;
    }
	
	public static Cipher encrypt(SecretKey sk){
		Cipher cipher = null;
		
		try {
			cipher = Cipher.getInstance(Algorithm.AES.getAlgorithm());
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		
        try {
			cipher.init(Cipher.ENCRYPT_MODE, sk);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
        
        return cipher;
    }
}
