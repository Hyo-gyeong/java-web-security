// 컴퓨터학과, 20190975, 신효경
package pr02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Scanner;

import javax.crypto.NoSuchPaddingException;

public class pr02VerificationMode {
	static final String PATH = "./src/pr02/";
	
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
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PATH+fileName))) {
            return (PublicKey) in.readObject();
        }
    }
	
	public static PrivateKey loadPrivateKeyFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PATH+fileName))) {
            return (PrivateKey) in.readObject();
        }
    }
	
	static byte[] readHashFromFile(String fname) throws IOException {
		byte[] result = new byte[128];
		try {
            FileInputStream in = new FileInputStream(PATH+fname);
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
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, ClassNotFoundException, IOException, NoSuchPaddingException {	

		Scanner sc = new Scanner(System.in);
		
		System.out.print("데이터 파일 이름 : ");
		String inputFileName = sc.nextLine();
		String inputString = readFileToString(inputFileName);
		byte[] inputBytes = inputString.getBytes();
		
        PrivateKey privateKey = loadPrivateKeyFromFile("private.key");
		String signAlgorithm = "SHA1withRSA";
		Signature sig = Signature.getInstance(signAlgorithm);
		sig.initSign(privateKey);
		sig.update(inputBytes);
		byte[] signature = sig.sign(); //입력된 데이터의 암호화된 해시값 반환
		
		System.out.print("공개키 파일 이름 : ");
		String publicSaveFile = sc.next();
		PublicKey publicKey = loadPublicKeyFromFile(publicSaveFile);
		
		System.out.print("전자서명 파일 이름 : ");
		String dataFileName = sc.next();
        byte[] byteArray = readHashFromFile(dataFileName); // pr01SignMode에서 생성한 해시값 읽어오기
        
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
