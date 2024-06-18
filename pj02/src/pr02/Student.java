// 컴퓨터학과, 20190975, 신효경
package pr02;

public class Student implements Comparable<Student>{

	private String subject;
	private int stdNumber;
	private String name;
	
	public Student (String subject, int stdNumber, String name){
		this.subject = subject;
		this.stdNumber = stdNumber;
		this.name = name;
	}
	
	public int compareTo(Student s) {
		return this.stdNumber - s.stdNumber;
	}
	
	@Override
	public String toString() {
		return subject+"/"+stdNumber+"/"+name;
	}
}
