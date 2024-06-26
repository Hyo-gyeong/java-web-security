// 컴퓨터학과, 20190975, 신효경
package object;

import java.time.LocalDate;

public class Patient implements Cloneable{ //보안적으로 보완 필요
	private String personId;
	private String name;
	private LocalDate birthDate;
	private String gender;
	private String phoneNumber;
	private String address;
	
	public Patient() {}
	
	public Patient(String personId, String name, LocalDate birthDate, String gender, String phoneNumber, String address) {
		this.personId = personId;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Patient clone() throws CloneNotSupportedException{
		Patient patient = (Patient) super.clone();
		Patient clonedPatient = null;
		
		String personId = patient.getPersonId();
		String name = patient.getName();
		LocalDate birthDate = patient.getBirthDate();
		String gender = patient.getGender();
		String phoneNumber = patient.getPhoneNumber();
		String address = patient.getAddress();
		
		clonedPatient = new Patient(personId, name, birthDate, gender, phoneNumber, address);
		
		return clonedPatient;
	}
	
	@Override
	public String toString() {
		return "Patient [personId=" + personId + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", address=" + address + "]";
	}
	
	public String getPersonId() { 
		return personId;
	}
	public String getName() {
		return name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public String getGender() {
		return gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
}
