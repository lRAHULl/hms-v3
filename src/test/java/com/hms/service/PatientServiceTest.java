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

    @Test
    public void createPatient() {
        Patient patient = new Patient();
        String username = "hjvfjbljavchgc";
        patient.setUsername(username);
        patient.setPassword("hello");
        patient.setFirstName("th");
        patient.setLastName("yh");
        patient.setBloodGroup("A+");
        patient.setPatientWeight(65);
        patient.setPatientHeight(198);
        int id = patientService.createPatient(patient);
        assert patientService.getPatient(id).getUsername().equals(username);
    }

    @Test
    public void updatePatient() {
        Patient patient = new Patient();
        patient.setPatientHeight(198);
        patient.setPatientWeight(90);
        patient.setPkUserId(51);
        patient.setPassword("bill");
        patient.setAge(18);
        assert patientService.updatePatient(patient) == 1;
    }

    @Test
    public void deletePatient() {
        assert patientService.deletePatient(123) == 1;
    }

}
