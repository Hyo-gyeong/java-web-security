package hospital;

import java.time.LocalDate;

import id_manager.IdGenerator;
import object.Doctor;
import object.MedicalRecord;
import object.Patient;


public class Hospital implements Cloneable{
	private static Patient patient = null;
	private static MedicalRecord medicalRecord = null;
	private static Doctor doctor = null;
	
	public Hospital() {
		String doctorId = IdGenerator.getRandomId();
		doctor = new Doctor(doctorId, "Park", "Cardiology", "A Hospital", 15);
		
		String pId = IdGenerator.getRandomId();
		patient = new Patient(pId, "Kelly", LocalDate.of(1990, 5, 26), "Female",
							"010-1234-2345", "123 Main Street, New York, NY 10001, United States");

		medicalRecord = new MedicalRecord(IdGenerator.getRandomId(), pId, doctorId, LocalDate.of(2003, 4, 3),
										"Blood test: Normal", 
										"Hypertension", 
										"Amoxicillin 500mg, take twice daily for 7 days", 
										"Patient complains of persistent cough and fever.");
	}
	
	public Patient getPatient() throws CloneNotSupportedException {
		Patient tmpPatient = patient.clone();
		return tmpPatient;
	}

	public MedicalRecord getMedicalRecord() throws CloneNotSupportedException {
		MedicalRecord clone = medicalRecord.clone();
		return clone;
	}

	public Doctor getDoctor() throws CloneNotSupportedException {
		Doctor tmpDoctor =  doctor.clone();
		return tmpDoctor;
	}
}
