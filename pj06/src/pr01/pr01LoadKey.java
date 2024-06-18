// 컴퓨터학과, 20190975, 신효경
package pr01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.crypto.SecretKey;

public class pr01LoadKey {
	
	public static SecretKey loadKeyFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./src/pr01/"+fileName))) {
            return (SecretKey) in.readObject();
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

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀키를 저장한 파일 이름: ");
		String fileName = sc.next();
		SecretKey sKey = loadKeyFromFile(fileName);
		System.out.println("암호화 알고리즘: " + sKey.getAlgorithm());
		System.out.println("키의 길이 (bytes): " + sKey.getEncoded().length);		
		System.out.print(bytesToHex(sKey.getEncoded()));
		sc.close();
	}

}
