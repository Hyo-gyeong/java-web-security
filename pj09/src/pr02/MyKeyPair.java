// 컴퓨터학과, 20190975, 신효경
package pr02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class MyKeyPair {
	private static final String PATH = "./src/pr02/";
	private String publicKeyPath = PATH + "public.key";
	private String privateKeyPath = PATH + "private.key";

	private static final String keyAlgorithm = "RSA";
	
	private KeyPairGenerator keyGen;
	private KeyPair pair;
	
	private PrivateKey privateKey;
	private PublicKey publicKey;
	
	public static MyKeyPair getInstance(int keylength) throws NoSuchAlgorithmException {
		MyKeyPair rslt = new MyKeyPair();
		
		rslt.keyGen = KeyPairGenerator.getInstance(keyAlgorithm);
		rslt.keyGen.initialize(keylength);
		
		return rslt;
	}
	
	public void createAndSaveKeys() {
		this.pair = this.keyGen.generateKeyPair();
		this.privateKey = pair.getPrivate();
		this.publicKey = pair.getPublic();
		try (ObjectOutputStream public_out = new ObjectOutputStream(new FileOutputStream(publicKeyPath))){
			public_out.writeObject(this.publicKey);
			try (ObjectOutputStream private_out = new ObjectOutputStream(new FileOutputStream(privateKeyPath))) {
				private_out.writeObject(this.privateKey);
	        }
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}
}
