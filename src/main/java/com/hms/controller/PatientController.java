package com.hms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.mapper.PatientMapper;
import com.hms.model.Patient;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {
	PatientMapper mapper;

	public PatientController(PatientMapper mapper) {
		this.mapper = mapper;
	}

	@GetMapping("/")
	public List<Patient> getPatients() {
		return mapper.getPatients();
	}

	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable("id") int id) {
		return mapper.getPatient(id);
	}

	@PostMapping("/")
	public int createPatient(@RequestBody Patient patient) {
		mapper.createUser(patient);
		mapper.createPatient(patient);
		return patient.getPkUserId();
	}

	@PutMapping("/")
	public int updatePatient(@RequestBody Patient patient) {
		mapper.updateUser(patient);
		mapper.updatePatient(patient);
		return patient.getPkUserId();
	}

	@DeleteMapping("/")
	public int deletePatient(@RequestBody Patient patient) {
		mapper.deleteUser(patient);
		mapper.deletePatient(patient);
		return patient.getPkUserId();
	}
}
