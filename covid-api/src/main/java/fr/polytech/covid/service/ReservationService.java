package fr.polytech.covid.service;

import fr.polytech.covid.entity.Center;
import fr.polytech.covid.entity.Patient;
import fr.polytech.covid.entity.Reservation;
import fr.polytech.covid.repository.PatientRepository;
import fr.polytech.covid.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;

    public ReservationService(ReservationRepository reservationRepository, PatientRepository patientRepository) {
        this.reservationRepository = reservationRepository;
        this.patientRepository = patientRepository;
    }

    public Reservation getReservationOfPatient(int patient_id){
        Patient patient = patientRepository.findById(patient_id).orElse(null);
        if(patient != null) return getReservationOfPatient(patient);
        else return null;
    }
    public Reservation getReservationOfPatient(Patient patient){
        return reservationRepository.findByPatient(patient);
    }

    public List<Reservation> reservations() {
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);
        return reservations;
    }

    public List<Reservation> reservations(Center center){
        return new ArrayList<>(reservationRepository.findByCenter(center));
    }

    public void addReservation(Reservation reservation){reservationRepository.save(reservation);}

    public void deleteReservation(Reservation reservation){
        reservationRepository.delete(reservation);
    }


}
