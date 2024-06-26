// 컴퓨터학과, 20190975, 신효경
package sign;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

import enums.Algorithm;


public class verificationMode {
	
	public static boolean verify(PublicKey pk, byte[] inputBytes, byte[] signature) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException{			
		boolean isVerified;
		
		Signature sig = Signature.getInstance(Algorithm.SHA1_WITH_RSA.getAlgorithm());
		sig.initVerify(pk); // Initialize the signer with public key
		sig.update(inputBytes); // 입력한 값으로 업데이트 해주고
		isVerified = sig.verify(signature); // 파일에서 읽어온 해시값과 비교
		
		return isVerified;
	}

}
