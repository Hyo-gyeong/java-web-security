// 컴퓨터학과, 20190975, 신효경
package research_center;

import id_manager.IdGenerator;
import object.Researcher;


public class ResearchCenter {
	public ResearchCenter() {
		String researcherId = IdGenerator.getRandomId();
		Researcher researcher = new Researcher(researcherId, "Lee", "Computer Science", "B Research Center", 10);
	}
}
