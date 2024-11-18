package com.abdullahaslan.midterm.RequestTypes;

import java.sql.Date;
import java.util.List;

public class ReportFlightsRequest {

    private String from;
    private String to;
    private List<Date> dates;
    private int capacity;

    public ReportFlightsRequest(String from, String to, List<Date> dates, int capacity) {
        this.from = from;
        this.to = to;
        this.dates = dates;
        this.capacity = capacity;
    }

    public ReportFlightsRequest() {
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

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
