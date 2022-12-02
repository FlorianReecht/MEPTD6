package fr.polytech.covid.controller;

import fr.polytech.covid.entity.Patient;
import fr.polytech.covid.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("api/admin")

public class AdminPatientController {


    private final PatientService patientService;

    public AdminPatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatientsByName(@RequestParam String last_name){
        return ResponseEntity.ok(patientService.getPatients(last_name));
    }

    @PutMapping("/patient")
    public void confirmVaccination(@RequestBody Patient patient){
        patientService.confirmVaccination(patient);
    }
}
