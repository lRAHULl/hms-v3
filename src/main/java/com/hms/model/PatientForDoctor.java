package com.hms.model;

public class PatientForDoctor {
	private int fkPatientId;
	private int fkRoleId;
	private String username;
	private String firstName;
	private String lastName;
	private int age;
	private int patientHeight;
	private int patientWeight;
	private String street;
	private String city;
	private String doorNo;
	private String bloodGroup;
	private int fkDoctorId;

	public int getFkPatientId() {
		return fkPatientId;
	}

	public void setFkPatientId(int fkPatientId) {
		this.fkPatientId = fkPatientId;
	}

	public int getFkRoleId() {
		return fkRoleId;
	}

	public void setFkRoleId(int fkRoleId) {
		this.fkRoleId = fkRoleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPatientHeight() {
		return patientHeight;
	}

	public void setPatientHeight(int patientHeight) {
		this.patientHeight = patientHeight;
	}

	public int getPatientWeight() {
		return patientWeight;
	}

	public void setPatientWeight(int patientWeight) {
		this.patientWeight = patientWeight;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getFkDoctorId() {
		return fkDoctorId;
	}

	public void setFkDoctorId(int fkDoctorId) {
		this.fkDoctorId = fkDoctorId;
	}

	@Override
	public String toString() {
		return "PatientForDoctor [fkPatientId=" + fkPatientId + ", fkRoleId=" + fkRoleId + ", username=" + username
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", patientHeight="
				+ patientHeight + ", patientWeight=" + patientWeight + ", street=" + street + ", city=" + city
				+ ", doorNo=" + doorNo + ", bloodGroup=" + bloodGroup + ", fkDoctorId=" + fkDoctorId
				+ ", getFkPatientId()=" + getFkPatientId() + ", getFkRoleId()=" + getFkRoleId() + ", getUsername()="
				+ getUsername() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getAge()=" + getAge() + ", getPatientHeight()=" + getPatientHeight() + ", getPatientWeight()="
				+ getPatientWeight() + ", getStreet()=" + getStreet() + ", getCity()=" + getCity() + ", getDoorNo()="
				+ getDoorNo() + ", getBloodGroup()=" + getBloodGroup() + ", getFkDoctorId()=" + getFkDoctorId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
