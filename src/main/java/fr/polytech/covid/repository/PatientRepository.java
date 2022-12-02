package fr.polytech.covid.repository;

import fr.polytech.covid.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient,Integer> {
    List<Patient> findByLastNameContainsIgnoreCase(String lastName);
}
