package com.abdullahaslan.midterm.RequestTypes;

import java.sql.Date;
import java.util.List;

public class InsertFlightRequest {

    //     from, to, available dates, capacity
    private String from;
    private String to;
    private List<Date> availableDates;
    private int capacity;

    public InsertFlightRequest() {
    }

    public InsertFlightRequest(String from, String to, List<Date> availableDates, int capacity) {
        this.from = from;
        this.to = to;
        this.availableDates = availableDates;
        this.capacity = capacity;
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

    public List<Date> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<Date> availableDates) {
        this.availableDates = availableDates;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
