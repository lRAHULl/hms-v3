package com.hms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.mapper.DoctorMapper;
import com.hms.model.Doctor;
import com.hms.model.PatientForDoctor;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

	@Autowired
	DoctorMapper mapper;

	@GetMapping("/")
	public List<Doctor> getDoctors() {
		return mapper.getDoctors();
	}

	@GetMapping("/{id}")
	public Doctor getDoctor(@PathVariable("id") int id) {
		return mapper.getDoctor(id);
	}

	@PostMapping("/")
	public int createDoctor(@RequestBody Doctor doctor) {
		mapper.createUser(doctor);
		mapper.createDoctor(doctor);
		return doctor.getPkUserId();
	}

	@GetMapping("/{id}/patients")
	public List<PatientForDoctor> getPatiensForDoctor(@PathVariable("id") int id) {
		return mapper.getPatientsForDoctor(id);
	}

	@GetMapping("/getPatients")
	public Map<Integer, List<PatientForDoctor>> getPatientsForDoctors() {
		List<PatientForDoctor> list = mapper.getPatientsForDoctors();
		Map<Integer, List<PatientForDoctor>> map = new HashMap<Integer, List<PatientForDoctor>>();
		for (PatientForDoctor p : list) {
			if (map.containsKey(p.getFkDoctorId())) {
				map.get(p.getFkDoctorId()).add(p);
			} else {
				map.put(p.getFkDoctorId(), new ArrayList<PatientForDoctor>());
				map.get(p.getFkDoctorId()).add(p);
			}
		}
		return map;
	}
}
