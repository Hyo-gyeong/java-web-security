// 컴퓨터학과, 20190975, 신효경
package pr03;

import java.util.Comparator;

public class SortByMajorNum implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getSubject().compareTo(o2.getSubject()) > 0) {
			return 1;
		}
		else if (o1.getSubject().compareTo(o2.getSubject()) < 0) {
			return -1;
		}
		else {
			if (o1.getStdNumber() > o2.getStdNumber()) {
				return 1; //오름차순
			}
			else if (o1.getStdNumber() < o2.getStdNumber()) {
				return -1;
			}
			return 0;
		}
	}

}
