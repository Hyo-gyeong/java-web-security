// 컴퓨터학과, 20190975, 신효경
package print;

public class print {
	public static void bytesToHex(byte[] bytes) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		for (byte b : bytes) {
			if (i != 0 && i % 20 == 0) {
				result.append("\n");
			}
			result.append(String.format("%02X ", b));
			i++;
		}
		System.out.println(result.toString());
	}
}
