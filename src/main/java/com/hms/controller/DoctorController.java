package com.hms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.mapper.DoctorMapper;
import com.hms.model.Doctor;
import com.hms.model.PatientForDoctor;
import com.hms.service.DoctorService;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

	@Autowired
	DoctorMapper mapper;
	
	@Autowired
	DoctorService service;

	@GetMapping("/")
	public List<Doctor> getDoctors() {
		List<Doctor> doctors = service.getDoctors();
		
		return doctors;
	}

	@GetMapping("/{id}")
	public Doctor getDoctor(@PathVariable("id") int id) {
		Doctor doctor = mapper.getDoctor(id);
		
		return doctor;
	}

	@PostMapping("/")
	public int createDoctor(@RequestBody Doctor doctor) {
		mapper.createUser(doctor);
		mapper.createDoctor(doctor);
		return doctor.getPkUserId();
	}

	@PutMapping("/")
	public int updateDoctor(@RequestBody Doctor doctor) {
		mapper.updateUser(doctor);
		return mapper.updateDoctor(doctor);
	}

	@DeleteMapping("/")
	public int deleteDoctor(@RequestBody Doctor doctor) {
		mapper.deleteUser(doctor);
		return mapper.deleteDoctor(doctor);
	}

	@GetMapping("/{id}/patients")
	public List<PatientForDoctor> getPatiensForDoctor(@PathVariable("id") int id) {
		List<PatientForDoctor> patientsForDoctor =  service.getPatientsForDoctor(id);
		
		return patientsForDoctor;
	}

	@GetMapping("/getPatients")
	public Map<Integer, List<PatientForDoctor>> getPatientsForDoctors() {
		Map<Integer, List<PatientForDoctor>> patientsForDoctors = service.getPatientsForDoctors();
		
		return patientsForDoctors;
	}
}
