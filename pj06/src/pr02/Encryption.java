// 컴퓨터학과, 20190975, 신효경
package pr02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Encryption {
	public static String readFileToString(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("./src/pr02/"+filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }
	
	public static SecretKey loadKeyFromFile(String fileName) throws IOException, ClassNotFoundException {
		// pj06 -> pr01SaveKey에서 암호화 키를 생성하여 skey.txt에 저장했다는 전제하에 프로그램을 구현하였습니다.
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./src/pr01/"+fileName))) {
            return (SecretKey) in.readObject();
        }
    }

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀키 파일 :");
		String enc_file = sc.next();
		SecretKey sKey = loadKeyFromFile(enc_file);
		
		System.out.print("데이터 파일 이름 :");
		String data_file = sc.next();
		String data_str = readFileToString(data_file);
		byte[] data = data_str.getBytes();
		System.out.print("암호화 출력 파일 :");
		String encrypted_file = sc.next();		
		
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, sKey);
		
		try(FileOutputStream bos = new FileOutputStream("./src/pr02/"+encrypted_file);
				CipherOutputStream cos = new CipherOutputStream(bos, cipher)){
			cos.write(data);
			cos.flush();			
		} catch(IOException e) {
			e.printStackTrace();
		}
		sc.close();

	}

}
