// 컴퓨터학과, 20190975, 신효경
package pr01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.SecretKey;

public class pr01LoadKey {
	public static PublicKey loadPublicKeyFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./src/pr01/"+fileName))) {
            return (PublicKey) in.readObject();
        }
    }
	
	public static PrivateKey loadPrivateKeyFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./src/pr01/"+fileName))) {
            return (PrivateKey) in.readObject();
        }
    }

	// 바이트 배열을 16진수 문자열로 출력
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (byte b : bytes) {
        	if (i % 20 == 0) {
        		result.append("\n");
        	}
            result.append(String.format("%02X ", b));
            i++;
        }
        return result.toString();
    }
    
	public static void main(String[] args) throws NoSuchAlgorithmException, ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("공개키를 저장한 파일 이름: ");
		String publicSaveFile = sc.next();
		PublicKey publickey = loadPublicKeyFromFile(publicSaveFile);
		System.out.println("암호화 알고리즘: "+publickey.getAlgorithm());
		System.out.println("복구된 공개키 정보:");
		System.out.println("키의 길이 (bytes): "+publickey.getEncoded().length);
		System.out.println(bytesToHex(publickey.getEncoded()));
		
		
		System.out.print("개인키를 저장한 파일 이름: ");
		String privateSaveFile = sc.next();
		PrivateKey privateKey = loadPrivateKeyFromFile(privateSaveFile);
		System.out.println("암호화 알고리즘: "+privateKey.getAlgorithm());
		System.out.println("복구된 개인키 정보:");
		System.out.println("키의 길이 (bytes): "+privateKey.getEncoded().length);
		System.out.println(bytesToHex(privateKey.getEncoded()));
		sc.close();

	}

}
