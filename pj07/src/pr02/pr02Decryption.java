// 컴퓨터학과, 20190975, 신효경
package pr02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class pr02Decryption {	
//	public static String readFileToString(String filePath) throws IOException {
//        StringBuilder stringBuilder = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(new FileReader("./src/pr02/"+filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                stringBuilder.append(line);
//            }
//        }
//        return stringBuilder.toString();
//    }
	
	public static PublicKey loadPublicKeyFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./src/pr01/"+fileName))) {
            return (PublicKey) in.readObject();
        }
    }

	public static void main(String[] args) throws ClassNotFoundException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("복호화 키 파일 :");
		String secretKey_file = sc.next();
		PublicKey publicKey = loadPublicKeyFromFile(secretKey_file);
		Cipher cipher2 = Cipher.getInstance(publicKey.getAlgorithm());
		cipher2.init(Cipher.DECRYPT_MODE, publicKey);
		
		System.out.print("암호데이터 파일 :");
		String encrypted_file2 = sc.next();
		
		try (FileInputStream bis = new FileInputStream("./src/pr02/"+encrypted_file2);
				CipherInputStream cis = new CipherInputStream(bis, cipher2);
				BufferedReader br = new BufferedReader(new InputStreamReader(cis))){
			
			StringBuffer decrypted = new StringBuffer();
			
			String line = br.readLine();
			while(line != null) {
				decrypted.append(line);
				line = br.readLine();
			}
			System.out.println(decrypted);
		}catch(IOException e) {
			e.printStackTrace();
		}
		sc.close();
		

	}

}
