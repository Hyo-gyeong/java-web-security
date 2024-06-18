// 컴퓨터학과, 20190975, 신효경
package pr01;

import java.util.Random;
import java.util.Scanner;

public class pr01 {

	private static int whoswin(String com, String you) {
		if (com.equals("가위")) {
			if (you.equals("가위")) {
				return 0;
			}else if (you.equals("바위")) {
				return 1;
			}else {
				return -1;
			}
		}
		else if (com.equals("바위")) {
			if (you.equals("가위")) {
				return -1;
			}else if (you.equals("바위")) {
				return 0;
			}else {
				return 1;
			}
		}
		else {
			if (you.equals("가위")) {
				return 1;
			}else if (you.equals("바위")) {
				return -1;
			}else {
				return 0;
			}
		}
	}

	private static String getInput(Scanner s) throws InvalidInputException{
		System.out.print("당신의 입력: ");
		String input = s.next();
		
		if (input.equals("가위") || input.equals("바위") || input.equals("보")) {
			return input;
		}
		else{
			throw new InvalidInputException("잘못된 입력입니다.\n");
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		String[] list = {"가위", "바위", "보"};
		int randNum = random.nextInt(3);
		System.out.println("컴퓨터의 생성: " + list[randNum]);
		String input = null;
		try {
			input = getInput(sc);
		}catch (InvalidInputException e) {
			System.out.print(e.getMessage());
		}
		int result = whoswin(list[randNum], input);
		if (result == 0) {
			System.out.print("비겼습니다.");
		}else if (result == 1) {
			System.out.print("당신이 이겼습니다.");
		}else if (result == -1) {
			System.out.print("당신이 졌습니다.");
		}

	}

}
