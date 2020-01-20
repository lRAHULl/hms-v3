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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hms.model.Doctor;
import com.hms.service.DoctorService;

/**
 * This class handles all the doctor related routes in this application.
 *
 * @author rahul
 *
 */
@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {
	private static final Logger LOGGER = LogManager.getLogger(DoctorController.class);

	/**
	 * Dependency Injection of the Service object.
	 */
	@Autowired
	DoctorService service;

	/**
	 *
	 * @return list of doctors.
	 */
	@GetMapping("/")
	public List<Doctor> getDoctors() {
		LOGGER.traceEntry();
		List<Doctor> doctors = service.getDoctors();
		LOGGER.traceExit(doctors.toString());
		return doctors;
	}

	/**
	 *
	 * @param id of the doctor.
	 * @return doctor as an object.
	 */
	@GetMapping("/{id}")
	public Doctor getDoctor(@PathVariable("id") int id) {
		LOGGER.traceEntry(Integer.toString(id));
		Doctor doctor = service.getDoctor(id);
		LOGGER.traceExit(doctor.toString());
		return doctor;
	}

	/**
	 *
	 * @param doctor as an object to create.
	 * @return userId of the doctor.
	 */
	@PostMapping("/")
	public int createDoctor(@RequestBody Doctor doctor) {
		LOGGER.traceEntry(doctor.toString());
		int userId = service.createDoctor(doctor);
		LOGGER.traceExit(userId);
		return userId;
	}

	/**
	 *
	 * @param doctor as an object to update.
	 * @return int rows affected.
	 */
	@PutMapping("/")
	public int updateDoctor(@RequestBody Doctor doctor) {
		LOGGER.traceEntry(doctor.toString());
		int rowsAffected = service.updateDoctor(doctor);
		LOGGER.traceExit(rowsAffected);
		return rowsAffected;
	}

	/**
	 *
	 * @param doctor as an object to delete.
	 * @return int rows affected.
	 */
	@DeleteMapping("/")
	public int deleteDoctor(@RequestBody Doctor doctor) {
		LOGGER.traceEntry(doctor.toString());
		int rowsAffected = service.deleteDoctor(doctor);
		LOGGER.traceExit(rowsAffected);
		return rowsAffected;
	}

	/**
	 *
	 * @return List of doctorId as a key and list of patients as values.
	 */
	@GetMapping("/getPatients")
	public List<Doctor> getPatientsForDoctors(@RequestParam(name = "id", required = false) Integer id) {
		LOGGER.traceEntry();
		if (id == null) {

			id = 0;
		}
		List<Doctor> doctors = service.getPatientsForDoctor(id);
		LOGGER.traceExit(doctors.toString());
		return doctors;
	}

//	/**
//	 *
//	 * @param id of the doctor to display their patients.
//	 * @return List of patients for that doctor.
//	 */
//	@GetMapping("/getPatients/{id}")
//	public List<Doctor> getPatiensForDoctor(@PathVariable("id") int id) {
//		LOGGER.traceEntry(Integer.toString(id));
//		List<Doctor> patientsForDoctor = service.getPatientsForDoctor(id);
//		LOGGER.traceExit(patientsForDoctor.toString());
//		return patientsForDoctor;
//	}
}
