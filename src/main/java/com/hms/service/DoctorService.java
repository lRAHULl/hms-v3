package com.hms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.mapper.DoctorMapper;
import com.hms.model.Doctor;
import com.hms.model.PatientForDoctor;

@Service
public class DoctorService {

	@Autowired
	DoctorMapper mapper;
	
	public List<Doctor> getDoctors() {
		List<Doctor> doctors = mapper.getDoctors();
		
		return doctors;
	}
	
	public Doctor getDoctor(int id) {
		Doctor doctor = mapper.getDoctor(id);
		
		return doctor;
	}
	
	public List<PatientForDoctor> getPatientsForDoctor(int id) {
		List<PatientForDoctor> patientsForDoctor = mapper.getPatientsForDoctor(id);
		
		return patientsForDoctor;
	}
	
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
