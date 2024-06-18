// 컴퓨터학과, 20190975, 신효경
package pr01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

public class pr01SaveKey {

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
    
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("암호화 알고리즘: RSA");
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(1024);
		
		KeyPair keypair = keyPairGen.generateKeyPair();
		PublicKey publickey = keypair.getPublic();
		PrivateKey privatekey = keypair.getPrivate();
		
		System.out.println("생성된 공개키 정보:");
		System.out.print("키의 길이 (bytes):"+publickey.getEncoded().length);
		System.out.println(bytesToHex(publickey.getEncoded()));
		System.out.println();
		System.out.println("생성된 개인키 정보:");
		System.out.print("키의 길이 (bytes):"+privatekey.getEncoded().length);
		System.out.println(bytesToHex(privatekey.getEncoded()));
		
		System.out.print("공개키를 저장할 파일 이름: ");
		String publicSaveFile = sc.next();
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./src/pr01/"+publicSaveFile))) {
            out.writeObject(publickey);
        } catch (IOException e) {
        	e.printStackTrace();
        }
		System.out.print("개인키를 저장할 파일 이름: ");
		String privateSaveFile = sc.next();
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./src/pr01/"+privateSaveFile))) {
            out.writeObject(privatekey);
        } catch( IOException e) {
        	e.printStackTrace();
        }
		sc.close();

	}

}
