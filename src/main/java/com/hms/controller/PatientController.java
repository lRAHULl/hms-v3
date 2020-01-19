package com.hms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.model.Patient;
import com.hms.service.PatientService;

/**
 * This Class handles all the patients routes.
 * @author rahul
 *
 */
@RestController
@RequestMapping(value = "/patients")
public class PatientController {
	
	private static final Logger LOGGER = LogManager.getLogger(PatientController.class);
	
	/**
	 * Dependency Injection of PatientService Class.
	 */
	@Autowired
	PatientService service;

	/**
	 * 
	 * @return list of patients.
	 */
	@GetMapping("/")
	public List<Patient> getPatients() {
		LOGGER.traceEntry();
		List<Patient> patients = service.getPatients();
		LOGGER.traceExit(patients.toString());
		return patients;
	}

	/**
	 * 
	 * @param id of the patient to read.
	 * @return the patient object.
	 */
	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable("id") int id) {
		LOGGER.entry(id);
		Patient patient = service.getPatient(id);
		LOGGER.traceExit(patient.toString());
		return patient;
	}

	/**
	 * 
	 * @param patient as an object to create.
	 * @return int the id of the patient created.
	 */
	@PostMapping("/")
	public int createPatient(@RequestBody Patient patient) {
		LOGGER.traceEntry(patient.toString());
		int userId =  service.createPatient(patient);
		LOGGER.traceExit(userId);
		return userId;
	}

	/**
	 * 
	 * @param patient as an object to update.
	 * @return int the number of rows affected.
	 */
	@PutMapping("/")
	public int updatePatient(@RequestBody Patient patient) {
		LOGGER.traceEntry(patient.toString());
		int rowsAffected = service.updatePatient(patient);
		LOGGER.traceExit(rowsAffected);
		return rowsAffected;
	}

	/**
	 * 
	 * @param patient as an object to delete.
	 * @return int the number of rows affected.
	 */
	@DeleteMapping("/")
	public int deletePatient(@RequestBody Patient patient) {
		LOGGER.traceEntry(patient.toString());
		int rowsAffected =  service.deletePatient(patient);
		LOGGER.traceExit(rowsAffected);
		return rowsAffected;
	}
}
