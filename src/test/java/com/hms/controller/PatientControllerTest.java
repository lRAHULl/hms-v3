package com.hms.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

@SpringBootTest
public class PatientControllerTest {

    private PatientController patientController;

    @BeforeClass
    public void before() {
        patientController = new PatientController();
    }

}
