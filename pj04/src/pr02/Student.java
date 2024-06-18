// 컴퓨터학과, 20190975, 신효경
package pr02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable{
	// private static final long serialVersionUID = 1L;
	// 제 로컬 환경에서 실행이 되게끔 ID를 맞췄습니다.
	private static final long serialVersionUID = 4374722576259204644L;
			
	private int sid;
	private String name;
	private String major;
	
	Student (int sid, String name, String major){
		this.sid = sid;
		this.name = name;
		this.major = major;
	}
	
	static Student readObject(String fname) throws IOException {
		try (FileInputStream fis = new FileInputStream(fname)){
			try(ObjectInputStream ois = new ObjectInputStream(fis)){
				Object obj = ois.readObject();
				Student student = (Student) obj;
				return student;
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	static boolean writeObject(String fname, Student s) throws FileNotFoundException, IOException {
		try (FileOutputStream fstream = new FileOutputStream("./src/pr02/"+fname)){
			try(ObjectOutputStream ostream = new ObjectOutputStream(fstream)){
				ostream.writeObject(s);
				return true;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Student createStudent (String input) {
		String[] inputArr = input.split(" ");
		Student newStd = new Student(Integer.valueOf(inputArr[0]), inputArr[1], inputArr[2]);
		return newStd;
	}
	
	public String toString() {
		return "생성된 학생 객체의 정보입니다.\n"+
				"Student["+this.name+","+this.sid+","+this.major+"]";
	}

}
