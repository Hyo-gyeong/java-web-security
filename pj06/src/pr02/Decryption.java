// 컴퓨터학과, 20190975, 신효경
package pr02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Decryption {
	public static SecretKey loadKeyFromFile(String fileName) throws IOException, ClassNotFoundException {
		// pr01패키지의 pr01SaveKey를 실행하여 skey.txt에 키를 저장했다는 전제하에 프로그램을 구현하였습니다.
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./src/pr01/"+fileName))) {
            return (SecretKey) in.readObject();
        }
    }

	public static void main(String[] args) throws ClassNotFoundException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("비밀키 파일 :");
		String secretKey_file = sc.next();
		SecretKey sKey = loadKeyFromFile(secretKey_file);
		
		Cipher cipher = Cipher.getInstance(sKey.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, sKey);
		
		System.out.print("암호 파일 :");
		String entrypted_file = sc.next();
		
		try (FileInputStream bis = new FileInputStream("./src/pr02/"+entrypted_file);
				CipherInputStream cis = new CipherInputStream(bis, cipher);
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
