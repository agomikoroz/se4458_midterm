package com.abdullahaslan.midterm.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="username")
    private String username;

    public Passenger() {
    }

    public Passenger(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public Passenger(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
