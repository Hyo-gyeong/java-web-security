// 컴퓨터학과, 20190975, 신효경
package pr01;


public class Diary implements Cloneable {
	Date[] listOfDates = null;
	
	public Diary(){
		listOfDates = new Date[3];
		
		listOfDates[0] = new Date(2019, 5, 1);
		listOfDates[1] = new Date(2000, 1, 1);
		listOfDates[2] = new Date(1988, 12, 25);
	}
	
	public Object clone() throws CloneNotSupportedException {
		 return super.clone();
	}
	
	public static void printDateArray(String str, Date[] listOfDates) {
		int i = 1;
		System.out.println(str);
		System.out.print("{");
		for (Date date : listOfDates) {
			System.out.print(date.toString());
			if (i < listOfDates.length) {
				System.out.print(", ");
				i++;
			}
		}
		System.out.println("}");
	}

}
