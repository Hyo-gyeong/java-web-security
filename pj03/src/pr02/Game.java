// 컴퓨터학과, 20190975, 신효경
package pr02;

public enum Game {
	ROCK(0), PAPER(1), SCISSORS(2), ERROR(-1);
	
	private int codeNum;
	
	Game(int num){
		this.codeNum = num;
	}
	
	int getCodeNum() {
		return this.codeNum;
	}
	
	static Game encode (String str) {
		if (str.equals("가위")) {
			return SCISSORS;
		}
		else if (str.equals("바위")) {
			return ROCK;
		}
		else if (str.equals("보")) {
			return PAPER;
		}
		return ERROR;
	}
}
