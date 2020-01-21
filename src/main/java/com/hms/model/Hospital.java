package com.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_hospital")
public class Hospital {

	@Id
	@Column(name = "pk_hospital_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospitalId;

	@Column(name = "hospital_name")
	private String hospitalName;

	@Column(name = "is_deleted")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int isDeleted;

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", isDeleted=" + isDeleted
				+ ", getHospitalId()=" + getHospitalId() + ", getHospitalName()=" + getHospitalName()
				+ ", getIsDeleted()=" + getIsDeleted() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
