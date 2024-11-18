package com.abdullahaslan.midterm.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="passengerID")
    private int passengerID;
    @Column(name="flightID")
    private int flightID;
    @Column(name="checkedin")
    private boolean checkedin;

    public Ticket() {
    }

    public Ticket(int id, int passengerID, int flightID, boolean checkedIn) {
        this.id = id;
        this.passengerID = passengerID;
        this.flightID = flightID;
        this.checkedin = checkedIn;
    }

    public Ticket(int passengerID, int flightID, boolean checkedIn) {
        this.passengerID = passengerID;
        this.flightID = flightID;
        this.checkedin = checkedIn;
    }

    public boolean isCheckedin() {
        return checkedin;
    }

    public void setCheckedin(boolean checkedin) {
        this.checkedin = checkedin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int userID) {
        this.passengerID = userID;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }
}
