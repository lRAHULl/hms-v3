package com.hms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hms.model.Patient;

@Mapper
public interface PatientMapper {

	@Select("SELECT * FROM t_user JOIN t_patient ON t_user.pk_user_id=t_patient.fk_user_id WHERE t_user.is_deleted=0 AND fk_role_id=1")
	List<Patient> getPatients();

	@Select("SELECT * FROM t_user JOIN t_patient ON t_user.pk_user_id=t_patient.fk_user_id WHERE pk_user_id=#{id} AND t_user.is_deleted=0 AND fk_role_id=1")
	Patient getPatient(int id);

	@Insert("INSERT INTO t_user (username,password,fk_role_id,first_name,last_name,age) VALUES (#{username},#{password}, 1, #{firstName}, #{lastName}, #{age})")
	@Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
	int createUser(Patient patient);

	@Insert("INSERT INTO t_patient (fk_user_id,patient_height,patient_weight,door_no,street,city,blood_group) VALUES (#{pkUserId},#{patientHeight}, #{patientWeight},#{doorNo},#{street},#{city},#{bloodGroup})")
	@Options(useGeneratedKeys = true, keyProperty = "pkPatientId", keyColumn = "pk_patient_id")
	int createPatient(Patient patient);

	@Update("UPDATE t_user SET is_deleted=1 WHERE pk_user_id=#{pkUserId} AND is_deleted=0")
	int deleteUser(Patient patient);

	@Update("UPDATE t_patient SET is_deleted=1 WHERE fk_user_id=#{pkUserId} AND is_deleted=0")
	int deletePatient(Patient patient);

	@Update("UPDATE t_user SET password=#{password},age=#{age} WHERE pk_user_id=#{pkUserId} AND is_deleted=0")
	int updateUser(Patient patient);

	@Update("UPDATE t_patient SET patient_height=#{patientHeight},patient_weight=#{patientWeight} WHERE fk_user_id=#{pkUserId} AND is_deleted=0")
	int updatePatient(Patient patient);

}
