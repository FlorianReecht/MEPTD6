package fr.polytech.covid.controller;

import fr.polytech.covid.entity.Reservation;
import fr.polytech.covid.service.PatientService;
import fr.polytech.covid.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/public")
public class PublicReservationController {


    private final ReservationService reservationService;
    private final PatientService patientService;

    public PublicReservationController(
            ReservationService reservationService,
            PatientService patientService) {
        this.reservationService = reservationService;
        this.patientService = patientService;

    }


    @PostMapping("/reservation")
    public ResponseEntity<String> addReservation(@RequestBody Reservation reservation){
        patientService.addPatient(reservation.getPatient());
        reservationService.addReservation(reservation);
        return ResponseEntity.ok().build();
    }

}
