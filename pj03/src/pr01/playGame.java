// 컴퓨터학과, 20190975, 신효경
package pr01;

import java.util.Scanner;

public class playGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("컴퓨터의 입력: ");
		String inputC = sc.next();
		Game com = encode(inputC);
		
		System.out.print("당신의 입력: ");
		String inputP = sc.next();
		Game you = encode(inputP);		
		
		Score rslt = whoswin(com, you);
		if (rslt == Score.WIN) {
			System.out.print("당신이 이겼습니다.");
		} else if (rslt == Score.LOSE) {
			System.out.print("컴퓨터가 이겼습니다.");
		} else if (rslt == Score.EQUAL) {
			System.out.print("비겼습니다.");
		}

		sc.close();
	}

	static Game encode(String str) {
		if (str.equals("가위")) {
			return Game.SCISSORS;
		} else if (str.equals("바위")) {
			return Game.ROCK;
		} else if (str.equals("보")) {
			return Game.PAPER;
		}
		return Game.ERROR;
	}

	static Score whoswin(Game com, Game you) {
		if (com.equals(you)) {
			return Score.EQUAL;
		}
		if (com.equals(Game.PAPER)) {
			if (you.equals(Game.ROCK)) {
				return Score.LOSE;
			} else if (you.equals(Game.SCISSORS)) {
				return Score.WIN;
			}
		} else if (com.equals(Game.ROCK)) {
			if (you.equals(Game.SCISSORS)) {
				return Score.LOSE;
			} else if (you.equals(Game.PAPER)) {
				return Score.WIN;
			}
		} else if (com.equals(Game.SCISSORS)) {
			if (you.equals(Game.PAPER)) {
				return Score.LOSE;
			} else if (you.equals(Game.ROCK)) {
				return Score.WIN;
			}
		}
		return Score.ERROR;
	}
}
