// 컴퓨터학과, 20190975, 신효경
package pr02;

public enum Score {
	WIN, LOSE, EQUAL, ERROR;
	
	public static String print(Score s) {
		if (s.equals(WIN)) {
			return "당신이 이겼습니다.";
		} else if (s.equals(LOSE)) {
			return "컴퓨터가 이겼습니다.";
		} else if (s.equals(EQUAL)) {
			return "비겼습니다.";
		}else {
			return "에러";
		}
	}
}
