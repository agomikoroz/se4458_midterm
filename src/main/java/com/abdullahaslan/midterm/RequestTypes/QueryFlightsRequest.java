package com.abdullahaslan.midterm.RequestTypes;

import java.sql.Date;

public class QueryFlightsRequest {
    private String from;
    private String to;
    private Date date;

    public QueryFlightsRequest(String from, String to, Date date) {
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public QueryFlightsRequest() {
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
}
