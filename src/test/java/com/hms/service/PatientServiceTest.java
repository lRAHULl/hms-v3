package com.hms.service;

import com.hms.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    PatientService patientService;

    @Test
    public void getPatient() {
        Patient patient = patientService.getPatient(51);
        assert patient.getUsername().equals("billnye1");
    }

    @Test
    public void getPatients() {
        List<Patient> patients = patientService.getPatients();
        assert patients.get(0).getUsername().equals("billnye1");
    }

}
