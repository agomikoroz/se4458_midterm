package com.abdullahaslan.midterm.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="FlightDates")
public class FlightDates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="flightID")
    private int flightID;
    @Column(name="date")
    private Date date;
    @Column(name="bseat")
    private int bseat;

    public FlightDates() {
    }

    public FlightDates(int id, int flightID, Date date, int bookedSeat) {
        this.id = id;
        this.flightID = flightID;
        this.date = date;
        this.bseat = bookedSeat;
    }

    public FlightDates(int flightID, Date date, int bookedSeat) {
        this.flightID = flightID;
        this.date = date;
        this.bseat = bookedSeat;
    }

    public int getBseat() {
        return bseat;
    }

    public void setBseat(int bseat) {
        this.bseat = bseat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
