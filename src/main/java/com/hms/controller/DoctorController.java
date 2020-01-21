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
import com.hms.model.ResponseBody;
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
	 * @return response body list of doctors.
	 */
	@GetMapping("/")
	public ResponseBody getDoctors() {
		LOGGER.traceEntry();
		List<Doctor> doctors = service.getDoctors();
		ResponseBody response = new ResponseBody();
		response.setStatus(200);
		response.setData(doctors);
		LOGGER.traceExit(doctors.toString());
		return response;
	}

	/**
	 *
	 * @param id of the doctor.
	 * @return doctor as an object.
	 */
	@GetMapping("/{id}")
	public ResponseBody getDoctor(@PathVariable("id") int id) {
		LOGGER.traceEntry(Integer.toString(id));
		Doctor doctor = service.getDoctor(id);
		ResponseBody response = new ResponseBody();
		response.setStatus(200);
		response.setData(doctor);
		LOGGER.traceExit(doctor.toString());
		return response;
	}

	/**
	 *
	 * @param doctor as an object to create.
	 * @return userId of the doctor.
	 */
	@PostMapping("/")
	public ResponseBody createDoctor(@RequestBody Doctor doctor) {
		LOGGER.traceEntry(doctor.toString());
		int userId = service.createDoctor(doctor);
		ResponseBody response = new ResponseBody();
		response.setStatus(200);
		response.setData(userId);
		LOGGER.traceExit(userId);
		return response;
	}

	/**
	 *
	 * @param doctor as an object to update.
	 * @return int rows affected.
	 */
	@PutMapping("/")
	public ResponseBody updateDoctor(@RequestBody Doctor doctor) {
		LOGGER.traceEntry(doctor.toString());
		int rowsAffected = service.updateDoctor(doctor);
		ResponseBody response = new ResponseBody();
		response.setStatus(200);
		response.setData(rowsAffected);
		LOGGER.traceExit(rowsAffected);
		return response;
	}

	/**
	 *
	 * @param doctor as an object to delete.
	 * @return int rows affected.
	 */
	@DeleteMapping("/")
	public ResponseBody deleteDoctor(@RequestBody Doctor doctor) {
		LOGGER.traceEntry(doctor.toString());
		int rowsAffected = service.deleteDoctor(doctor);
		ResponseBody response = new ResponseBody();
		response.setStatus(200);
		response.setData(rowsAffected);
		LOGGER.traceExit(rowsAffected);
		return response;
	}

	/**
	 *
	 * @return List of doctorId as a key and list of patients as values.
	 */
	@GetMapping("/getPatients")
	public ResponseBody getPatientsForDoctors(@RequestParam(name = "id", required = false) Integer id) {
		LOGGER.traceEntry();
		if (id == null) {

			id = 0;
		}
		List<Doctor> doctors = service.getPatientsForDoctor(id);
		ResponseBody response = new ResponseBody();
		response.setStatus(200);
		response.setData(doctors);
		LOGGER.traceExit(doctors.toString());
		return response;
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
