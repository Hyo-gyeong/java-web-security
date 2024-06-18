// 컴퓨터학과, 20190975, 신효경
package pr02;

import java.util.Scanner;


public class playGame {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("컴퓨터의 입력 : ");
		String comInput = s.next();
		Game com = Game.encode(comInput);
		
		System.out.print("당신의 입력: ");
		String yourInput = s.next();
		Game user = Game.encode(yourInput);
		
		Score rslt = whoswin(user, com);
		System.out.println(Score.print(rslt));
		
		s.close();
	}
	
	static Score whoswin(Game you, Game com) {
		Score[][] scoreBoard = {
			{Score.EQUAL, Score.LOSE, Score.WIN},
			{Score.WIN, Score.EQUAL, Score.LOSE},
			{Score.LOSE, Score.WIN, Score.EQUAL}
		};
		
		return scoreBoard[you.getCodeNum()][com.getCodeNum()];
	}
}
