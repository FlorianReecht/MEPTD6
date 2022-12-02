package fr.polytech.covid.controller;

import fr.polytech.covid.entity.Center;
import fr.polytech.covid.entity.Reservation;
import fr.polytech.covid.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminReservationController {
    private final ReservationService reservationService;

    public AdminReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations(){
        return reservationService.reservations();
    }

    @GetMapping("/reservationsByCenter")
    public List<Reservation> getReservationsByCenter(@RequestBody Center center) {
        return reservationService.reservations(center);
    }

    @GetMapping("/reservation")
    public Reservation getReservationOfPatient(@RequestParam int patient_id){
        return reservationService.getReservationOfPatient(patient_id);
    }

    @DeleteMapping("/reservation")
    public void deleteReservation(@RequestBody Reservation reservation){
        reservationService.deleteReservation(reservation);
    }


}
