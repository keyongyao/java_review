package com.example.GOF23.chainofresponse;

/**
 * Created by Administrator on 2016/8/20.
 */
public class First implements Handle {
    private String who;
    private Handle nextHandler;

    public Handle getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handle nextHandler) {
        this.nextHandler = nextHandler;
    }

    public First(String who) {
        this.who = who;
    }

    @Override
    public void hadleRequest(Request request) {
        if (request.getRequestDays() <= 5)
            System.out.println(this.who + "处理了");
        else
            nextHandler.hadleRequest(request);
    }
}
