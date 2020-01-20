package com.hms.model;

import java.util.List;

/**
 * This is a Bean class used to represent the Doctor.
 *
 * @author Rahul
 */
public class Doctor extends User {
	private int pkDoctorId;
	private int experience;
	private String doctorSpecialisation;
	private List<Patient> patients;

	/**
	 *
	 * @return patients as a list.
	 */
	public List<Patient> getPatients() {
		return patients;
	}

	/**
	 *
	 * @param patients input.
	 */
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	/**
	 * Gets the doctorId.
	 *
	 * @return doctorId.
	 */
	public int getPkDoctorId() {
		return pkDoctorId;
	}

	/**
	 * Sets the doctorId.
	 *
	 * @param doctorId Integer.
	 */
	public void setPkDoctorId(int pkDoctorId) {
		this.pkDoctorId = pkDoctorId;
	}

	/**
	 * Gets the experience.
	 *
	 * @return experience.
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * Sets the experience.
	 *
	 * @param experience Integer.
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * Gets the specilization.
	 *
	 * @return specilization.
	 */
	public String getDoctorSpecialisation() {
		return doctorSpecialisation;
	}

	/**
	 * Sets the specilization.
	 *
	 * @param specilization String.
	 */
	public void setDoctorSpecialisation(String doctorSpecialisation) {
		this.doctorSpecialisation = doctorSpecialisation;
	}

	/**
	 * Returns the Doctor object as a string.
	 *
	 * @return Doctor as a string.
	 */
	@Override
	public String toString() {
		return "Doctor [pkDoctorId=" + pkDoctorId + ", experience=" + experience + ", doctorSpecialisation="
				+ doctorSpecialisation + ", getPkDoctorId()=" + getPkDoctorId() + ", getExperience()=" + getExperience()
				+ ", getDoctorSpecialisation()=" + getDoctorSpecialisation() + ", getPkUserId()=" + getPkUserId()
				+ ", getFkRoleId()=" + getFkRoleId() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getAge()=" + getAge() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
