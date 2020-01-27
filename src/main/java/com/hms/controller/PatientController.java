package com.hms.controller;

import java.util.List;

import com.hms.model.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hms.model.Patient;
import com.hms.service.PatientService;

/**
 * This Class handles all the patients routes.
 * 
 * @author rahul
 *
 */
@CrossOrigin
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
		LOGGER.traceEntry(Integer.toString(id));
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
	public ResponseBody createPatient(@RequestBody Patient patient) {
		LOGGER.traceEntry(patient.toString());
		int userId = service.createPatient(patient);
		ResponseBody response = new ResponseBody();
		response.setStatus(200);
		response.setData(userId);
		LOGGER.traceExit(userId);
		return response;
	}

	/**
	 *
	 * @param patient as an object to update.
	 * @return int the number of rows affected.
	 */
	@PutMapping("/")
	public ResponseBody updatePatient(@RequestBody Patient patient) {
		LOGGER.traceEntry(patient.toString());
		int rowsAffected = service.updatePatient(patient);
		ResponseBody response = new ResponseBody();
		response.setStatus(200);
		response.setData(rowsAffected);
		LOGGER.traceExit(rowsAffected);
		return response;
	}

	/**
	 *
	 * @param id as an object to delete.
	 * @return int the number of rows affected.
	 */
	@DeleteMapping("/{id}")
	public ResponseBody deletePatient(@PathVariable("id") int id) {
		LOGGER.traceEntry("Id" + id);
		int rowsAffected = service.deletePatient(id);
		ResponseBody response = new ResponseBody();
		response.setStatus(200);
		response.setData(rowsAffected);
		LOGGER.traceExit(rowsAffected);
		return response;
	}
}
