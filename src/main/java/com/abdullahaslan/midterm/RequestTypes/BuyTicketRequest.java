package com.abdullahaslan.midterm.RequestTypes;

import java.sql.Date;

public class BuyTicketRequest {

    private String from;
    private String to;
    private Date date;
    private String username;

    public BuyTicketRequest(String from, String to, Date date, String username) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.username = username;
    }

    public BuyTicketRequest() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
