package com.hms.service;

import com.hms.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.testng.Assert.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void updatePatient() {
        Patient patient = new Patient();
        patient.setPkPatientId(39);
        patient.setUsername("abcde");
        patient.setPassword("abcde");
        patient.setAge(56);
        patient.setPatientHeight(299);
        patient.setPatientWeight(89);

        int out = patientService.updatePatient(patient);
        assertEquals(0, out);
    }

}
