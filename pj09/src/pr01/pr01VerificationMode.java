// 컴퓨터학과, 20190975, 신효경
package pr01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class pr01VerificationMode {
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
	
	public static byte[] loadSignFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./src/pr01/"+fileName))) {
            return (byte[]) in.readObject();
        }
    }
	
	static byte[] readFromFile(String fname) throws IOException {
		byte[] result = new byte[128];
		try {
            FileInputStream in = new FileInputStream("./src/pr01/"+fname);
            int i = 0;
            int c;
            while((c = in.read()) != -1 ) {
            	result[i] = (byte)c; //읽은 바이트를 배열에 저장
                i++;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return result;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, ClassNotFoundException, IOException, NoSuchPaddingException {	

		Scanner sc = new Scanner(System.in);
		
		System.out.print("서명에 사용할 데이터 : ");
		String inputData = sc.nextLine();
		byte[] inputBytes = inputData.getBytes();
        PrivateKey privateKey = loadPrivateKeyFromFile("private.key");
		String signAlgorithm = "SHA1withRSA";
		Signature sig = Signature.getInstance(signAlgorithm);
		sig.initSign(privateKey);
		sig.update(inputBytes);
		byte[] signature = sig.sign(); //입력된 데이터의 암호화된 해시값 반환
//		System.out.println(bytesToHex(signature)); // 값이 같은지 확인하려고 출력
		
		System.out.print("공개키 파일 이름 : ");
		String publicSaveFile = sc.next();
		PublicKey publicKey = loadPublicKeyFromFile(publicSaveFile);
		
		System.out.print("전자서명 파일 이름 : ");
		String dataFileName = sc.next();
        byte[] byteArray = readFromFile(dataFileName); // pr01SignMode에서 생성한 해시값 읽어오기
//        System.out.println(bytesToHex(byteArray));
        
        System.out.println("\n입력된 서명 정보: " + signature.length + " bytes");
        System.out.println(bytesToHex(signature));
		
		Signature sig2 = Signature.getInstance(signAlgorithm);
		sig2.initVerify(publicKey); // Initialize the signer with public key
		sig2.update(inputBytes); // 입력한 값으로 업데이트 해주고
		boolean isVerified = sig2.verify(byteArray); // 파일에서 읽어온 해시값과 비교

        System.out.println("\n서명 검증 결과 : " + isVerified);
        
        sc.close();
	}

}
