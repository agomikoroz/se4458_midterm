package com.abdullahaslan.midterm.RequestTypes;

public class CheckInRequest {
    private int id;

    public CheckInRequest(int id) {
        this.id = id;
    }

    public CheckInRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
