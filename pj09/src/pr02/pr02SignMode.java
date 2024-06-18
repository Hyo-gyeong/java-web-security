// 컴퓨터학과, 20190975, 신효경
package pr02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Scanner;

public class pr02SignMode {
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
	
	public static PrivateKey loadPrivateKeyFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PATH+fileName))) {
            return (PrivateKey) in.readObject();
        }
    }
	
	public static void saveHashArray(byte[] hashValue, String saveF) throws IOException {
		FileOutputStream out = null;		
		try {
			try {
				out = new FileOutputStream(PATH+saveF);
				for (byte bytes : hashValue) {
					out.write(bytes);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}finally {
			if (out != null) {
				out.close();
			}
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
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, ClassNotFoundException, IOException {	

		Scanner sc = new Scanner(System.in);
		MyKeyPair myKeyPair = MyKeyPair.getInstance(1024); //static method이기 때문에 클래스 이름에서 가져와야함. new로 생성한 변수에 담으면 안됨
		myKeyPair.createAndSaveKeys();
		
		System.out.print("데이터 파일 이름 : ");
		String inputFileName = sc.nextLine();
		String inputString = readFileToString(inputFileName);
		byte[] data = inputString.getBytes();
		
		System.out.print("개인키 파일 이름 : ");
		String privateSaveFile = sc.next();
		PrivateKey privateKey = loadPrivateKeyFromFile(privateSaveFile);
		
		String signAlgorithm = "SHA1withRSA";
		Signature sig = Signature.getInstance(signAlgorithm); //Create an instance
		sig.initSign(privateKey); // Initialize the signer with private key
		sig.update(data); //Add data for signing
		byte[] signature = sig.sign(); //원래 데이터의 암호화된 해시값 반환
		
		System.out.println("\n생성된 서명 정보: " + signature.length + " bytes");
		System.out.println(bytesToHex(signature));
		
		System.out.print("\n서명을 저장할 파일 이름 :");
		String sigSaveFile = sc.next();
		saveHashArray(signature, sigSaveFile);
		System.out.print("서명을 파일에 저장했습니다.");
		sc.close();
	}

}
