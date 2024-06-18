// 컴퓨터학과, 20190975, 신효경
package pr01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class pr01SaveKey {
	
	public static void saveKeyToFile(SecretKey key, String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./src/pr01/"+fileName))) {
            out.writeObject(key);
        }
    }
	
	// 바이트 배열을 16진수 문자열로 출력
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X ", b));
        }
        return result.toString();
    }

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);	
		System.out.print("암호화 알고리즘: ");
		String algorithm = sc.next();
		
		System.out.print("키의 길이 (bytes): ");
		int len = sc.nextInt();
		
		KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
		keyGen.init(len*8);
		SecretKey secretKey = keyGen.generateKey();
		
		System.out.println(bytesToHex(secretKey.getEncoded()));
		
		System.out.print("비밀키를 저장할 파일 이름: ");
		String saveFile = sc.next();
		saveKeyToFile(secretKey, saveFile);
		sc.close();
	}
}
