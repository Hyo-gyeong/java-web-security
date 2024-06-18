// 컴퓨터학과, 20190975, 신효경
package pr02;

public class Diary implements Cloneable {
	Date[] listOfDates = null;
	
	public Diary(){
		listOfDates = new Date[3];
		
		listOfDates[0] = new Date(2019, 5, 1);
		listOfDates[1] = new Date(2000, 1, 1);
		listOfDates[2] = new Date(1988, 12, 25);
	}
	
	public static void clone(Date[] listOfDate, Date[] cloneDate) throws CloneNotSupportedException {
		int i = 0;
		for (Date date : listOfDate) {
			int newYear = date.getYear();
			int newMonth = date.getMonth();
			int newDate = date.getDate();
			cloneDate[i] = new Date(newYear, newMonth, newDate);
			i++;
		}
	}

}
