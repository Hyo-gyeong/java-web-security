// 컴퓨터학과, 20190975, 신효경
package object;

public class Researcher {
    private String researcherId;
    private String name;
    private String researchArea; //연구 분야
    private String affiliation; //소속 기관 또는 연구소
    private int yearsOfExperience; //경력(년)

    public Researcher(String researcherId, String name, String researchArea, String affiliation, int yearsOfExperience) {
        this.researcherId = researcherId;
        this.name = name;
        this.researchArea = researchArea;
        this.affiliation = affiliation;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getResearcherId() {
        return researcherId;
    }

    public String getName() {
        return name;
    }

    public String getResearchArea() {
        return researchArea;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

	@Override
	public String toString() {
		return "Researcher [researcherId=" + researcherId + ", name=" + name + ", researchArea=" + researchArea
				+ ", affiliation=" + affiliation + ", yearsOfExperience=" + yearsOfExperience + "]";
	}
}
