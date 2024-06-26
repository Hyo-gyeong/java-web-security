// 컴퓨터학과, 20190975, 신효경
package object;

public class Doctor implements Cloneable{
    private String doctorId;
    private String name;
    private String specialty; //전문 분야
    private String hospital; //소속 병원
    private int yearsOfExperience; //경력(년)
    
    public Doctor(String doctorId, String name, String specialty, String hospital, int yearsOfExperience) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialty = specialty;
        this.hospital = hospital;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Doctor clone() throws CloneNotSupportedException{
		Doctor doctor = (Doctor) super.clone();
		Doctor cloneDoctor = null;
		
		String doctorId = doctor.getDoctorId();
	    String name = doctor.getName();
	    String specialty = doctor.getSpecialty();
	    String hospital = doctor.getHospital();
	    int yearsOfExperience = doctor.getYearsOfExperience();
	    
	    cloneDoctor = new Doctor(doctorId, name, specialty, hospital, yearsOfExperience);
	    
	    return cloneDoctor;
	}
    
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", specialty=" + specialty + ", hospital=" + hospital
				+ ", yearsOfExperience=" + yearsOfExperience + "]";
	}
	
	private String getDoctorId() {
        return this.doctorId;
    }

    private String getName() {
        return this.name;
    }

    private String getSpecialty() {
        return this.specialty;
    }

    private String getHospital() {
        return this.hospital;
    }

    private int getYearsOfExperience() {
        return this.yearsOfExperience;
    }
}

