// 컴퓨터학과, 20190975, 신효경
package pr02;

import java.util.Scanner;

public class pr02 {
	public static void printDateArray(String str, Date[] listOfDates) {
		int i = 1;
		System.out.print(str + "\n{");
		for (Date date : listOfDates) {
			System.out.print(date.toString());
			if (i < listOfDates.length) {
				System.out.print(", ");
				i++;
			}
		}
		System.out.println("}");
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner sc = new Scanner(System.in);
		Diary diary = new Diary();
		
		Date[] originDate = diary.listOfDates;
		Date[] cloneDate = new Date[originDate.length];
		Diary.clone(originDate, cloneDate);
		
		printDateArray("Original Array:", originDate);
		printDateArray("Cloned Array:", cloneDate);
		
		System.out.print("변경하고 싶은 배열을 선택하세요(1-original/2-cloned):");
		int choice = sc.nextInt();
		System.out.print("변경하고 싶은 날짜의 인덱스를 입력하세요:");
		int index = sc.nextInt();
		System.out.print("년도: ");
		int newYear = sc.nextInt();
		System.out.print("월: ");
		int newMonth = sc.nextInt();
		System.out.print("일: ");
		int newDate = sc.nextInt();
		
		if (choice != 1 && choice != 2) {
			System.out.println("입력이 잘못 되었습니다. 프로그램을 종료합니다.");
		}else {
			Date selected = null;
			if (choice == 1) {
				selected = originDate[index];
			}else if (choice == 2) {
				selected = cloneDate[index];
			}
			selected.setYear(newYear);
			selected.setMonth(newMonth);
			selected.setDate(newDate);
		}
		
		printDateArray("Original Array:", originDate);
		printDateArray("Cloned Array:", cloneDate);
		
		sc.close();
	}

}
