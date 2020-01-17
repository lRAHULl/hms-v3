package com.hms.model;

/**
 * This is a Bean class used to represent the Doctor.
 *
 * @author Rahul
 */
public class Doctor extends User {
	private int pkDoctorId;
	private int experience;
	private String doctorSpecilization;

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
	public String getDoctorSpecilization() {
		return doctorSpecilization;
	}

	/**
	 * Sets the specilization.
	 *
	 * @param specilization String.
	 */
	public void setDoctorSpecilization(String doctorSpecilization) {
		this.doctorSpecilization = doctorSpecilization;
	}

	/**
	 * Returns the Doctor object as a string.
	 *
	 * @return Doctor as a string.
	 */
	@Override
	public String toString() {
		return "Doctor [pkDoctorId=" + pkDoctorId + ", experience=" + experience + ", doctorSpecilization="
				+ doctorSpecilization + ", getPkDoctorId()=" + getPkDoctorId() + ", getExperience()=" + getExperience()
				+ ", getDoctorSpecilization()=" + getDoctorSpecilization() + ", getPkUserId()=" + getPkUserId()
				+ ", getFkRoleId()=" + getFkRoleId() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getAge()=" + getAge() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
}
