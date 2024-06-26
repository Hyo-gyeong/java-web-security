package crypto_manager;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import enums.Algorithm;

public class DecryptionUtils {
	public static byte[] decrypt(byte[] cipherText, SecretKey sk) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        Cipher cipher = Cipher.getInstance(Algorithm.AES.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, sk);
        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return decryptedBytes;
    }
    
    public static SecretKey decryptSecretKey(byte[] encryptedKey, PrivateKey pk) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        Cipher cipher = Cipher.getInstance(pk.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, pk);
        byte[] decryptedKey = cipher.doFinal(encryptedKey);
        
        // SecretKey 복원, AES 알고리즘 사용
        return new SecretKeySpec(decryptedKey, Algorithm.AES.getAlgorithm());
    }
}
