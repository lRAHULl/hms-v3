package com.hms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hms.constants.QueryConstants;
import com.hms.model.Patient;

/**
 * This class is responsible for performing CRUD in the database for all the patients.
 * @author rahul
 *
 */
@Mapper
public interface PatientMapper {

	/**
	 * 
	 * @return list of patients.
	 */
	@Select(QueryConstants.READ_ALL_PATIENTS)
	List<Patient> getPatients();

	/**
	 * 
	 * @param id of the patient to read.
	 * @return the patient object.
	 */
	@Select(QueryConstants.READ_PATIENT_BY_ID)
	Patient getPatient(int id);

	/**
	 * 
	 * @param patient as an object to create.
	 * @return the number of rows affected in the DB.
	 */
	@Insert(QueryConstants.USER_PATIENT_INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
	int createUser(Patient patient);

	/**
	 * 
	 * @param patient as an object to create.
	 * @return the number of rows affected in the DB.
	 */
	@Insert(QueryConstants.PATIENT_INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "pkPatientId", keyColumn = "pk_patient_id")
	int createPatient(Patient patient);

	/**
	 * 
	 * @param patient as an object to update.
	 * @return the number of rows affected in the DB.
	 */
	@Update(QueryConstants.USER_UPDATE)
	int updateUser(Patient patient);

	/**
	 * 
	 * @param patient as an object to update.
	 * @return the number of rows affected in the DB.
	 */
	@Update(QueryConstants.PATIENT_UPDATE)
	int updatePatient(Patient patient);

	/**
	 * 
	 * @param patient as an object to delete.
	 * @return the number of rows affected in the DB.
	 */
	@Update(QueryConstants.USER_DELETE)
	int deleteUser(int id);

	/**
	 * 
	 * @param patient as an object to delete.
	 * @return the number of rows affected in the DB.
	 */
	@Update(QueryConstants.PATIENT_DELETE)
	int deletePatient(int id);

}
