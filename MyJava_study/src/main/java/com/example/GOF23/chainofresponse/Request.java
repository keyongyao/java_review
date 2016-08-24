package com.example.GOF23.chainofresponse;

/**
 * Created by Administrator on 2016/8/20.
 */
public class Request {
    private int requestDays;

    public Request(int requestDays) {
        this.requestDays = requestDays;
    }

    public int getRequestDays() {
        return requestDays;
    }

    public void setRequestDays(int requestDays) {
        this.requestDays = requestDays;
    }
}
