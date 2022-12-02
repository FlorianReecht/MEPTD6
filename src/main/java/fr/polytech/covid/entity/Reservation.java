package fr.polytech.covid.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue
    private int id;
    private Date date;
    @ManyToOne
    @JoinColumn(name="center_id")
    private Center center;

    @OneToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    public Reservation() {
    }

    public Reservation(Date date, Center center, Patient patient) {
        this.date = date;
        this.center = center;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
