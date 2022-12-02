package fr.polytech.covid.controller;

import fr.polytech.covid.entity.Patient;
import fr.polytech.covid.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public")
public class PublicPatientController {
    private final PatientService patientService;

    public PublicPatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patient")
    public Patient addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

}
