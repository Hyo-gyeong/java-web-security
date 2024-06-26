// 컴퓨터학과, 20190975, 신효경
package object;

import java.time.LocalDate;

public class MedicalRecord implements Cloneable{
	private String recordId;
	private String personId;
	private String doctorId;
	private LocalDate date;
	private String labResults; //검사결과
	private String diagnoses; // 진단정보
	private String prescription; //처방내용
	private String doctorNotes; //의사의 노트
	
	public MedicalRecord(String recordId, String personId, String doctorId, LocalDate date, String labResults, 
			String diagnoses, String prescription, String doctorNotes) {
		this.recordId = recordId;
		this.personId = personId;
		this.doctorId = doctorId;
		this.date = date;
		this.labResults = labResults;
		this.diagnoses = diagnoses;
		this.prescription = prescription;
		this.doctorNotes = doctorNotes;
	}

	public MedicalRecord clone() throws CloneNotSupportedException{
		MedicalRecord record = (MedicalRecord) super.clone();
		MedicalRecord clonedRecord = null;
		
		String recordId = record.getRecordId();
	    String personId = record.getPersonId();
	    String doctorId = record.getDoctorId();
	    LocalDate date = record.getDate();
	    String labResults = record.getLabResults();
	    String diagnoses = record.getDiagnoses();
	    String prescription = record.getPrescription();
	    String doctorNotes = record.getDoctorNotes();
	    
	    clonedRecord = new MedicalRecord(recordId, personId, doctorId, date, labResults, diagnoses, prescription, doctorNotes);
	    
	    return clonedRecord;
	}

	@Override
	public String toString() {
		return "MedicalRecord [recordId=" + recordId + ", personId=" + personId + ", doctorId=" + doctorId + ", date="
				+ date + ", labResults=" + labResults + ", diagnoses=" + diagnoses + ", prescription=" + prescription
				+ ", doctorNotes=" + doctorNotes + "]";
	}
	
	private String getRecordId() {
		return recordId;
	}

	private String getPersonId() {
		return personId;
	}

	private String getDoctorId() {
		return doctorId;
	}

	private LocalDate getDate() {
		return date;
	}

	private String getLabResults() {
		return labResults;
	}

	private String getDiagnoses() {
		return diagnoses;
	}

	private String getPrescription() {
		return prescription;
	}

	private String getDoctorNotes() {
		return doctorNotes;
	}
	
}
