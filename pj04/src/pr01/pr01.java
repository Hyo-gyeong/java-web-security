// 컴퓨터학과, 20190975, 신효경
package pr01;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class pr01 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String input;
		Student std;		
		
		System.out.print("내보내기 = 1, 읽어오기 = 2를 입력 : ");
		int choice = Integer.parseInt(sc.nextLine());
		if (choice == 1) {
			System.out.print("학생 정보를 입력하세요 : ");
			input = sc.nextLine();
			std = Student.createStudent(input);
			System.out.println(std.toString());
			
			System.out.print("정보를 저장할 파일 이름을 입력하세요: ");
			input = sc.next();
			std.writeToFile(input);
			System.out.print("프로그램을 종료합니다.");
		}
		else if (choice == 2) {
			System.out.print("정보를 읽어올 파일 이름을 입력하세요: ");
			input = sc.next();
			std = Student.readFromFile(input);
			System.out.println(std.toString());
		}
		else {
			System.out.println("입력이 잘못되었습니다. 프로그램을 종료합니다.");
		}
		sc.close();

	}

}
