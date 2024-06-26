package pr02;

import java.time.Month;

public class Date {
	private int year;
	private int month;
	private int day;

	public Date() {}
	
//	public Date(int a) {
//		this. = a;
//	}
	
//	public Date(int a, int b) {
//		this. = a;
//		this. = b;
//	}
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	protected boolean isReap() {
		if (this.year % 4 == 0) {
			return true;
		}
		return false;
	}
	
//	public String testReapYears() {
//		
//	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public static int compareDate(Date d1, Date d2) {
		return Date.compareDate(d1, d2);
		// -1 : d1이 과거, 0 : 같음, 1 : d1이 최신
	}
	public String printWestern() {
        // 월의 이름을 문자열로 변환
        String monthName = Month.of(month).name();
        // 첫 글자를 대문자로 변경하고, 나머지는 소문자로 변경
        monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1).toLowerCase();
        // "April 5, 2005"와 같은 형식으로 날짜를 출력
        return monthName + " " + day + ", " + year;
	}

	@Override
	public String toString() {
		return "Date [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
}
