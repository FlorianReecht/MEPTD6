package fr.polytech.covid.repository;

import fr.polytech.covid.entity.Center;
import fr.polytech.covid.entity.Patient;
import fr.polytech.covid.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
    List<Reservation> findByCenter(Center center);

    Reservation findByPatient(Patient patient);


}
