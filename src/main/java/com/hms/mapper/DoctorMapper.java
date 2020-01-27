package com.hms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hms.constants.QueryConstants;
import com.hms.model.Doctor;
import com.hms.model.Patient;

/**
 * This class does CRUD for doctors in the DataBase.
 *
 * @author rahul
 *
 */
@Mapper
public interface DoctorMapper {

	/**
	 *
	 * @return list of doctors from the database.
	 */
	@Select(QueryConstants.READ_ALL_DOCTORS)
	List<Doctor> getDoctors();

	/**
	 *
	 * @param id of the doctor.
	 * @return Doctor as an object.
	 */
	@Select(QueryConstants.READ_DOCTOR_BY_ID)
	Doctor getDoctor(int id);

	/**
	 *
	 * @param doctor as an object to create.
	 * @return number of rows affected.
	 */
	@Insert(QueryConstants.USER_DOCTOR_INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
	int createUser(Doctor doctor);

	/**
	 *
	 * @param doctor as an object to create.
	 * @return number of rows affected.
	 */
	@Insert(QueryConstants.DOCTOR_INSERT)
	int createDoctor(Doctor doctor);

	/**
	 *
	 * @param doctor as an object to update.
	 * @return number of rows affected.
	 */
	@Update(QueryConstants.USER_UPDATE)
	int updateUser(Doctor doctor);

	/**
	 *
	 * @param doctor as an object to update.
	 * @return number of rows affected.
	 */
	@Update(QueryConstants.DOCTOR_UPDATE)
	int updateDoctor(Doctor doctor);

	/**
	 *
	 * @param id as an object to delete.
	 * @return number of rows affected.
	 */
	@Update(QueryConstants.USER_DELETE)
	int deleteUser(int id);

	/**
	 *
	 * @param doctor as an object to delete.
	 * @return number of rows affected.
	 */
	@Update(QueryConstants.DOCTOR_DELETE)
	int deleteDoctor(int id);

	/**
	 *
	 * @param id of the doctor.
	 * @return list of patients for the given doctorId.
	 */
	@Select(QueryConstants.GET_PATIENTS_FOR_DOCTOR)
	List<Patient> getPatients(int id);

	/**
	 *
	 * @param id of the doctor to retrieve the object with a list of patients.
	 * @return List of doctor(s) with a list of patients.
	 */
	@Select(QueryConstants.READ_DOCTOR_BY_ID)
	@Results(value = {
			@Result(property = "patients", column = "fk_user_id", javaType = List.class, many = @Many(select = "getPatients")) })
	List<Doctor> getPatientsForDoctor(int id);

//	/**
//	 *
//	 * @return list of all the patients with the related doctors.
//	 */
//	@Select(QueryConstants.READ_ALL_DOCTORS)
//	@Results(value = {
//			@Result(property = "patients", column = "fk_user_id", javaType = List.class, many = @Many(select = "getPatients")) })
//	List<Doctor> getPatientsForDoctors();
}
