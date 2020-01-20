package com.hms.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.mapper.DoctorMapper;
import com.hms.model.Doctor;

/**
 * This class contains all the business logic for doctor routes.
 *
 * @author rahul
 *
 */
@Service
public class DoctorService {

	private static final Logger LOGGER = LogManager.getLogger(DoctorService.class);
	/**
	 * Dependency Injection of the Mapper object.
	 */
	@Autowired
	DoctorMapper mapper;

	/**
	 *
	 * @return list of doctors from DB.
	 */
	public List<Doctor> getDoctors() {
		LOGGER.traceEntry();
		List<Doctor> doctors = mapper.getDoctors();
		LOGGER.traceExit(doctors.toString());
		return doctors;
	}

	/**
	 *
	 * @param id of the doctor.
	 * @return doctor as an object.
	 */
	public Doctor getDoctor(int id) {
		LOGGER.traceEntry(Integer.toString(id));
		Doctor doctor = mapper.getDoctor(id);
		LOGGER.traceExit(doctor.toString());
		return doctor;
	}

	/**
	 *
	 * @param doctor as an object to create.
	 * @return userId of the doctor.
	 */
	public int createDoctor(Doctor doctor) {
		LOGGER.traceEntry(doctor.toString());
		mapper.createUser(doctor);
		mapper.createDoctor(doctor);
		int userId = doctor.getPkUserId();
		LOGGER.traceExit(userId);
		return userId;
	}

	/**
	 *
	 * @param doctor as an object to update.
	 * @return int rows affected.
	 */
	public int updateDoctor(Doctor doctor) {
		LOGGER.traceEntry(doctor.toString());
		mapper.updateUser(doctor);
		int rowsAffected = mapper.updateDoctor(doctor);
		LOGGER.traceExit(rowsAffected);
		return rowsAffected;
	}

	/**
	 *
	 * @param doctor as an object to delete.
	 * @return int rows affected.
	 */
	public int deleteDoctor(Doctor doctor) {
		LOGGER.traceEntry(doctor.toString());
		mapper.deleteUser(doctor);
		int rowsAffected = mapper.deleteDoctor(doctor);
		LOGGER.traceExit(rowsAffected);
		return rowsAffected;
	}

	/**
	 *
	 * @param id of the doctor to display their patients.
	 * @return List of patients for that doctor.
	 */
	public List<Doctor> getPatientsForDoctor(int id) {
		LOGGER.traceEntry(Integer.toString(id));
		List<Doctor> patientsForDoctor = mapper.getPatientsForDoctor(id);
		LOGGER.traceExit(patientsForDoctor.toString());
		return patientsForDoctor;
	}

//	/**
//	 *
//	 * @return HashMap of doctorId as a key and list of patients as values.
//	 */
//	public List<Doctor> getPatientsForDoctors() {
//		LOGGER.traceEntry();
//	List<Doctor> list = mapper.getPatientsForDoctors();
//		Map<Integer, List<PatientForDoctor>> map = new HashMap<Integer, List<PatientForDoctor>>();
//		for (PatientForDoctor p : list) {
//			if (map.containsKey(p.getFkDoctorId())) {
//				map.get(p.getFkDoctorId()).add(p);
//			} else {
//				map.put(p.getFkDoctorId(), new ArrayList<PatientForDoctor>());
//				map.get(p.getFkDoctorId()).add(p);
//			}
//		}
//		LOGGER.traceExit(list.toString());
//		return list;
//	}
}
