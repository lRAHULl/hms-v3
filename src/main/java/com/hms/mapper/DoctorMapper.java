package com.hms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.hms.model.Doctor;
import com.hms.model.PatientForDoctor;

@Mapper
public interface DoctorMapper {

	@Select("SELECT * FROM t_user JOIN t_doctor ON t_user.pk_user_id=t_doctor.fk_user_id WHERE t_user.is_deleted=0 AND fk_role_id=2")
	List<Doctor> getDoctors();

	@Select("SELECT * FROM t_user JOIN t_doctor ON t_user.pk_user_id=t_doctor.fk_user_id WHERE pk_user_id=#{id} AND t_user.is_deleted=0 AND fk_role_id=2")
	Doctor getDoctor(int id);

	@Insert("INSERT INTO t_user (username,password,fk_role_id,first_name,last_name,age) VALUES (#{username},#{password}, 2, #{firstName}, #{lastName}, #{age})")
	@Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
	int createUser(Doctor doctor);

	@Insert("INSERT INTO t_doctor (fk_user_id,doctor_specialisation,experience) VALUES (#{pkUserId}, #{doctorSpecialisation}, #{experience})")
	int createDoctor(Doctor doctor);

	@Select("select * from t_user join t_patient on t_user.pk_user_id=t_patient.fk_user_id join t_patient_doctor_mapping on t_user.pk_user_id=t_patient_doctor_mapping.fk_patient_id join t_user as u on t_patient_doctor_mapping.fk_doctor_id=u.pk_user_id where u.is_deleted=0 AND t_patient_doctor_mapping.fk_doctor_id=#{id}")
	List<PatientForDoctor> getPatientsForDoctor(int id);

	@Select("select * from t_user join t_patient on t_user.pk_user_id=t_patient.fk_user_id join t_patient_doctor_mapping on t_user.pk_user_id=t_patient_doctor_mapping.fk_patient_id join t_user as u on t_patient_doctor_mapping.fk_doctor_id=u.pk_user_id where u.is_deleted=0")
	List<PatientForDoctor> getPatientsForDoctors();

	void updateUser(Doctor doctor);

	int deleteDoctor(Doctor doctor);

	int updateDoctor(Doctor doctor);

	void deleteUser(Doctor doctor);
}
