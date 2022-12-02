package fr.polytech.covid.service;

import fr.polytech.covid.entity.Patient;
import fr.polytech.covid.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

   public List<Patient>getPatients( String lastName){
       return new ArrayList<>(patientRepository.findByLastNameContainsIgnoreCase(lastName));
   }

   public Patient addPatient(Patient patient){
       return patientRepository.save(patient);
   }

   public void confirmVaccination(Patient patient){
        patient.setVaccinated(true);
        patientRepository.save(patient);
   }
}
