package com.abdullahaslan.midterm.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="`from`")
    private String from;
    @Column(name="`to`")
    private String to;
    @Column(name="`seat`")
    private int seat;

    public Flight() {
    }

    public Flight(int id, String from, String to, int maxSeat) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.seat = maxSeat;
    }

    public Flight(String from, String to, int maxSeat) {
        this.from = from;
        this.to = to;
        this.seat = maxSeat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", maxSeat=" + seat +
                '}';
    }
}