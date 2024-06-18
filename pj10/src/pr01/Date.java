// 컴퓨터학과, 20190975, 신효경
package pr01;

public class Date {

	private int year;
	private int month;
	private int date;
	
	public Date(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String toString() {
		return year + "년 " + month + "월 " + date + "일";
	}

}
