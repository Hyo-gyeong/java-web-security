// 컴퓨터학과, 20190975, 신효경
package pr02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class pr02 {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("해시값 저장 = 1, 해시값 비교 = 2 : ");
		int choice = Integer.parseInt(sc.next());
		
		System.out.print("입력 파일 이름 : ");
		String ifname = sc.next();
		byte[] content = readFromFile(ifname);
		byte[] digest = Digest(content);
		printResult(digest);
		
		if (choice == 1) {		
			System.out.print("해시값을 저장할 파일이름 : ");
			String saveF = sc.next();
			saveHashArray(digest, saveF);
		} else if (choice == 2) {
			System.out.print("저장된 해시값 파일이름 : ");
			String s = sc.next();
			byte[] content2 = readFromFile(s);
			compareText(digest, content2);
		}
		else {
			System.out.print("잘못된 입력입니다. 프로그램을 종료합니다.");
		}
		sc.close();
	}
	
	static byte[] readFromFile(String fname) throws IOException {
		byte[] result = new byte[200];
		try {
            FileInputStream in = new FileInputStream("./src/pr02/"+fname);
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
	
	public static void saveHashArray(byte[] hashValue, String saveF) throws IOException {
		FileOutputStream out = null;		
		try {
			try {
				out = new FileOutputStream("./src/pr02/"+saveF);
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
	
	public static void compareText(byte[] plainArray, byte[] modifiedArray) {
		for (int i = 0; i < plainArray.length; i++) {
			if (plainArray[i] != modifiedArray[i]) {
				System.out.print("비교 결과 : false");
				return;
			}
		}
		System.out.print("비교 결과 : true");
		return;
	}
	
	public static byte[] Digest (byte[] barr) throws NoSuchAlgorithmException {
		byte[] SHA1;
		
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
		messageDigest.update(barr);
		SHA1 = messageDigest.digest();
		
		return SHA1;
	}

	public static void printResult (byte[] byteArray) {
		System.out.println("계산된 해시값");
		
		for (byte bytes : byteArray) {
			System.out.print(String.format("%02x", bytes) + "\t");
		}
		
		System.out.println();
	}

}
