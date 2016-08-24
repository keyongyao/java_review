package com.example.GOF23.chainofresponse;

/**
 * Created by Administrator on 2016/8/20.
 */
public class Third implements Handle {
    private Handle nextHandle;
    private String who;

    public Third(String who) {
        this.who = who;
    }

    public Handle getNextHandle() {
        return nextHandle;
    }

    public void setNextHandle(Handle nextHandle) {
        this.nextHandle = nextHandle;
    }

    @Override
    public void hadleRequest(Request request) {
        if (request.getRequestDays() <= 15)
            System.out.println(this.who + "已经处理了");
        else
            System.out.println("不想读了?!");
    }
}
