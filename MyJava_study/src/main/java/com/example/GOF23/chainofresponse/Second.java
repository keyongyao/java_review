package com.example.GOF23.chainofresponse;

/**
 * Created by Administrator on 2016/8/20.
 */
public class Second implements Handle {
    private Handle nexthandle;
    private String who;

    public Second(String who) {
        this.who = who;
    }

    public Handle getNexthandle() {
        return nexthandle;
    }

    public void setNexthandle(Handle nexthandle) {
        this.nexthandle = nexthandle;
    }

    @Override
    public void hadleRequest(Request request) {
        if (request.getRequestDays() <= 10)
            System.out.println(this.who + "已经处理了");
        else
            nexthandle.hadleRequest(request);
    }
}
