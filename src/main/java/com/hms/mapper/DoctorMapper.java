package com.hms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.hms.constants.QueryConstants;
import com.hms.model.Doctor;
import com.hms.model.PatientForDoctor;

@Mapper
public interface DoctorMapper {

	@Select(QueryConstants.READ_ALL_DOCTORS)
	List<Doctor> getDoctors();

	@Select(QueryConstants.READ_DOCTOR_BY_ID)
	Doctor getDoctor(int id);

	@Insert(QueryConstants.USER_DOCTOR_INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
	int createUser(Doctor doctor);

	@Insert(QueryConstants.DOCTOR_INSERT)
	int createDoctor(Doctor doctor);

	int updateUser(Doctor doctor);

	int updateDoctor(Doctor doctor);

	int deleteUser(Doctor doctor);
	
	int deleteDoctor(Doctor doctor);
	
	@Select(QueryConstants.GET_PATIENTS_FOR_DOCTOR)
	List<PatientForDoctor> getPatientsForDoctor(int id);

	@Select(QueryConstants.GET_PATIENTS_FOR_ALL_DOCTORS)
	List<PatientForDoctor> getPatientsForDoctors();
}
