// 컴퓨터학과, 20190975, 신효경
package sign;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;

import enums.Algorithm;

public class signMode {	
	public static byte[] sign(byte[] inputData, PrivateKey privateKey) {	
		Signature sig = null;
		byte[] signature = null;
		
		try { //Create an instance
			sig = Signature.getInstance(Algorithm.SHA1_WITH_RSA.getAlgorithm());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		try { // Initialize the signer with private key
			sig.initSign(privateKey);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		
		try { //Add data for signing
			sig.update(inputData);
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		
		try { //원래 데이터의 암호화된 해시값 반환
			signature = sig.sign();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		
		return signature;
	}
}
