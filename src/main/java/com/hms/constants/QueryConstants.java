package com.hms.constants;

/**
 * This class contains all the DB query constants used in the application.
 * @author rahul
 *
 */
public class QueryConstants {
	
	public static final String USER_PATIENT_INSERT = "INSERT INTO t_user (username,password,fk_role_id,first_name,last_name,age) VALUES (#{username},#{password}, 1, #{firstName}, #{lastName}, #{age})";
	public static final String USER_DOCTOR_INSERT = "INSERT INTO t_user (username,password,fk_role_id,first_name,last_name,age) VALUES (#{username},#{password}, 2, #{firstName}, #{lastName}, #{age})";
	public static final String USER_UPDATE = "UPDATE t_user SET password=#{password},age=#{age} WHERE pk_user_id=#{pkUserId} AND is_deleted=0";
	public static final String USER_DELETE = "UPDATE t_user SET is_deleted=1 WHERE pk_user_id=#{pkUserId} AND is_deleted=0";
	
	public static final String READ_ALL_PATIENTS = "SELECT * FROM t_user JOIN t_patient ON t_user.pk_user_id=t_patient.fk_user_id WHERE t_user.is_deleted=0 AND fk_role_id=1";
	public static final String READ_PATIENT_BY_ID = "SELECT * FROM t_user JOIN t_patient ON t_user.pk_user_id=t_patient.fk_user_id WHERE pk_user_id=#{id} AND t_user.is_deleted=0 AND fk_role_id=1";
	public static final String PATIENT_INSERT = "INSERT INTO t_patient (fk_user_id,patient_height,patient_weight,door_no,street,city,blood_group) VALUES (#{pkUserId},#{patientHeight}, #{patientWeight},#{doorNo},#{street},#{city},#{bloodGroup})";
	public static final String PATIENT_UPDATE = "UPDATE t_patient SET patient_height=#{patientHeight},patient_weight=#{patientWeight} WHERE fk_user_id=#{pkUserId} AND is_deleted=0";
	public static final String PATIENT_DELETE = "UPDATE t_patient SET is_deleted=1 WHERE fk_user_id=#{pkUserId} AND is_deleted=0";

	public static final String READ_ALL_DOCTORS = "SELECT * FROM t_user JOIN t_doctor ON t_user.pk_user_id=t_doctor.fk_user_id WHERE t_user.is_deleted=0 AND fk_role_id=2";
	public static final String READ_DOCTOR_BY_ID = "SELECT * FROM t_user JOIN t_doctor ON t_user.pk_user_id=t_doctor.fk_user_id WHERE pk_user_id=#{id} AND t_user.is_deleted=0 AND fk_role_id=2";
	public static final String DOCTOR_INSERT = "INSERT INTO t_doctor (fk_user_id,doctor_specialisation,experience) VALUES (#{pkUserId}, #{doctorSpecialisation}, #{experience})";
	public static final String DOCTOR_UPDATE = "UPDATE t_doctor SET doctor_specialisation=#{doctorSpecialisation},experience=#{experience} WHERE fk_user_id=#{pkUserId} AND is_deleted=0";
	public static final String DOCTOR_DELETE = "UPDATE t_doctor SET is_deleted=1 WHERE fk_user_id=#{pkUserId} AND is_deleted=0";
	
	public static final String GET_PATIENTS_FOR_DOCTOR = "select * from t_user join t_patient on t_user.pk_user_id=t_patient.fk_user_id join t_patient_doctor_mapping on t_user.pk_user_id=t_patient_doctor_mapping.fk_patient_id join t_user as u on t_patient_doctor_mapping.fk_doctor_id=u.pk_user_id where u.is_deleted=0 AND t_patient_doctor_mapping.fk_doctor_id=#{id}";
	public static final String GET_PATIENTS_FOR_ALL_DOCTORS = "select * from t_user join t_patient on t_user.pk_user_id=t_patient.fk_user_id join t_patient_doctor_mapping on t_user.pk_user_id=t_patient_doctor_mapping.fk_patient_id join t_user as u on t_patient_doctor_mapping.fk_doctor_id=u.pk_user_id where u.is_deleted=0";
}
