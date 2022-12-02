package fr.polytech.covid.controller;

import fr.polytech.covid.entity.Reservation;
import fr.polytech.covid.service.PatientService;
import fr.polytech.covid.service.ReservationService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;


@RestController
@RequestMapping("api/public")
public class PublicReservationController {

    Refill refill = Refill.intervally(10, Duration.ofMinutes(1));
    Bandwidth limit = Bandwidth.classic(10, refill);
    Bucket bucket = Bucket.builder().addLimit(limit).build();
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
        if(bucket.tryConsume(1)){
            patientService.addPatient(reservation.getPatient());
            reservationService.addReservation(reservation);
            return ResponseEntity.ok("Réservation effectuée.");
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }

}
