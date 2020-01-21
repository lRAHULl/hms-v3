package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.model.Hospital;
import com.hms.service.HospitalService;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

	@Autowired
	HospitalService service;

	@PostMapping("/")
	public Hospital createHospital(@RequestBody Hospital hospital) {
		return service.createHospital(hospital);
	}

	@PutMapping("/")
	public Hospital updateHospital(@RequestBody Hospital hospital) {
		return service.updateHospital(hospital);
	}
}
