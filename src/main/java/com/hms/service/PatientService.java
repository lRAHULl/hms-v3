package com.hms.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.mapper.PatientMapper;
import com.hms.model.Patient;

/**
 * This Class contains all the business logic for handling patients.
 * @author rahul
 *
 */
@Service
public class PatientService {
	
	private static final Logger LOGGER = LogManager.getLogger(PatientService.class);
	
	/**
	 * Dependency Injection of mapper object. 
	 */
	@Autowired
	PatientMapper mapper;
	
	/**
	 * 
	 * @return list of patients.
	 */
	public List<Patient> getPatients() {
		LOGGER.traceEntry();
		List<Patient> patients = mapper.getPatients();
		LOGGER.traceExit(patients.toString());
		return patients;
	}
	
	/**
	 * 
	 * @param id of the patient to get the details.
	 * @return the patient object.
	 */
	public Patient getPatient(int id) {
		LOGGER.entry(id);
		Patient patient = mapper.getPatient(id);
		LOGGER.traceExit(patient.toString());
		return patient;
	}
	
	/**
	 * 
	 * @param patient as an object to create.
	 * @return the id of the created patient.
	 */
	public int createPatient(Patient patient) {
		LOGGER.traceEntry(patient.toString());
		mapper.createUser(patient);
		mapper.createPatient(patient);
		int userId = patient.getPkUserId();
		LOGGER.traceExit(userId);
		return userId;
	}
	
	/**
	 * 
	 * @param patient as an object to update.
	 * @return the number of rows affected in the database.
	 */
	public int updatePatient(Patient patient) {
		LOGGER.traceEntry(patient.toString());
		mapper.updateUser(patient);
		int rowsAffected = mapper.updatePatient(patient);
		LOGGER.traceExit(rowsAffected);
		return rowsAffected;
	}
	
	/**
	 * 
	 * @param patient as an object to delete.
	 * @return the number of rows affected in the database.
	 */
	public int deletePatient(Patient patient) {
		mapper.deleteUser(patient);
		int rowsAffected =  mapper.deletePatient(patient);
		LOGGER.traceExit(rowsAffected);
		return rowsAffected;
	}
}
