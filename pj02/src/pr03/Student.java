// 컴퓨터학과, 20190975, 신효경
package pr03;

public class Student{

	private String subject;
	private int stdNumber;
	private String name;
	
	public Student (String subject, int stdNumber, String name){
		this.subject = subject;
		this.stdNumber = stdNumber;
		this.name = name;
	}
	
	public String getSubject() {
		return subject;
	}

	public int getStdNumber() {
		return stdNumber;
	}

	@Override
	public String toString() {
		return subject+"/"+stdNumber+"/"+name;
	}
}
