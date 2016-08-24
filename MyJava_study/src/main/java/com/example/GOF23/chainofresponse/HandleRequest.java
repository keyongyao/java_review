package com.example.GOF23.chainofresponse;

/**
 * Created by Administrator on 2016/8/20.
 */
public class HandleRequest {

    public static void main(String[] args) {
        First 班主任 = new First("班主任");
        Second 系主任 = new Second("系主任");
        Third 教育处处长 = new Third("教育处处长");
        班主任.setNextHandler(系主任);
        系主任.setNexthandle(教育处处长);

        班主任.hadleRequest(new Request(5));
        班主任.hadleRequest(new Request(10));
        班主任.hadleRequest(new Request(15));
        班主任.hadleRequest(new Request(20));

    }

}
