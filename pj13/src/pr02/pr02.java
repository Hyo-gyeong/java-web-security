package pr02;

import java.util.Scanner;

public class pr02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("날짜를 입력하세요 :");
		String userInput = sc.next();
		String[] numbers = userInput.split("-");

		int year = Integer.parseInt(numbers[0]);
		int month = Integer.parseInt(numbers[1]);
		int day = Integer.parseInt(numbers[2]);
		Date date = new Date(year, month, day);
		System.out.print(date.printWestern());
		
		sc.close();
	}

}
