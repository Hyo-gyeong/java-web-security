package crypto_manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import enums.Algorithm;

public class Hash {
	public static byte[] SHA1HashMedicalRecord(String mr){
		byte[] digest = null;
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance(Algorithm.SHA1.getAlgorithm());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(mr.getBytes());
		digest = md.digest();
		
		return digest;
	}
}
