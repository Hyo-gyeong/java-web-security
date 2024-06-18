// 컴퓨터학과, 20190975, 신효경
package pr01;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class pr01 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String plainTxt = "The Road Not Taken by Robert Frost";
		String modifiedPlainTxt = "The Road Not Ttaken by Robert Frost";
		byte[] MDSHA1_plain;
		byte[] MDSHA1_modified;
		
		MDSHA1_plain = Digest(plainTxt);
		printResult(plainTxt, MDSHA1_plain);		
		MDSHA1_modified = Digest(modifiedPlainTxt);
		printResult(modifiedPlainTxt, MDSHA1_modified);
		compareText(MDSHA1_plain, MDSHA1_modified);
	}
	
	public static void compareText(byte[] plainArray, byte[] modifiedArray) {
		int difference = 0;
		
		for (int i = 0; i < plainArray.length; i++) {
			if (plainArray[i] != modifiedArray[i]) {
				difference++;
			}
		}
		
		System.out.println("데이터에서 1글자 혹은 1단어가 달라지는 경우, 해시 값은 얼마나 영향을 받는가?\n"
				+ difference/plainArray.length*100);
	}
	
	public static byte[] Digest (String text) throws NoSuchAlgorithmException {
		byte[] MDSHA1;
		byte[] data;
		
		data = text.getBytes();
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
		messageDigest.update(data);
		MDSHA1 = messageDigest.digest();
		
		return MDSHA1;
	}

	public static void printResult (String text, byte[] byteArray) {
		System.out.println("plain text: " + text);
		System.out.println("length of digest (bytes) : " + byteArray.length);
		System.out.print("digestdSHA1 (hex) : ");
		
		for (byte bytes : byteArray) {
			System.out.print(String.format("%02x", bytes) + "\t");
		}
		
		System.out.println();
	}

}
