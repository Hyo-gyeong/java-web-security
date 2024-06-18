// 컴퓨터학과, 20190975, 신효경
package pr01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Student {
	
	private int sid;
	private String name;
	private String major;
	
	Student (int sid, String name, String major){
		this.sid = sid;
		this.name = name;
		this.major = major;
	}
	
	static Student readFromFile(String fname) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("./src/pr01/"+fname));
		Student std = new Student(sc.nextInt(), sc.next(), sc.next());
		
		if (sc != null) {
			sc.close();
		}
		
		return std;
	}

	boolean writeToFile(String fname) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("./src/pr01/"+fname));
			pw.println(this.sid);
			pw.println(this.name);
			pw.print(this.major);
			pw.flush();
			if (pw != null) {
				pw.close();
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public String toString() {
		return "생성된 학생 객체의 정보입니다.\n"+
				"Student["+this.name+","+this.sid+","+this.major+"]";
	}

	public static Student createStudent (String input) {
		String[] inputArr = input.split(" ");
		Student newStd = new Student(Integer.valueOf(inputArr[0]), inputArr[1], inputArr[2]);
		return newStd;
	}
}
