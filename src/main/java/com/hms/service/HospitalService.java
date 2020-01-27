package com.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.model.Hospital;
import com.hms.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	HospitalRepository repository;

	public Hospital createHospital(Hospital hospital) {
		return repository.save(hospital);
	}

	public Hospital updateHospital(Hospital hospital) {
		return repository.save(hospital);
	}
}
