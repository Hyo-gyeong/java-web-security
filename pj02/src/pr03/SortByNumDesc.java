// 컴퓨터학과, 20190975, 신효경
package pr03;

import java.util.Comparator;

public class SortByNumDesc implements Comparator<Student>{
	
	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getStdNumber() > o2.getStdNumber()) {
			return -1; //내림차순
		}
		else if (o1.getStdNumber() < o2.getStdNumber()) {
			return 1;
		}
		return 0;
	}

}
