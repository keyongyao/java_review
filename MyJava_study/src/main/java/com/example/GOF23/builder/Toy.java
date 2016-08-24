package com.example.GOF23.builder;

/**
 * Created by Administrator on 2016/8/18.
 */
public class Toy {
    private Object mounth;
    private Object nose;
    private Object hand;
    private Object feet;
    private Object head;
    private Object body;


    public Toy() {
    }

    @Override
    public String toString() {
        return "Toy{" +
                "mounth=" + mounth +
                ", nose=" + nose +
                ", hand=" + hand +
                ", feet=" + feet +
                ", head=" + head +
                ", body=" + body +
                '}';
    }

    public Object getMounth() {
        return mounth;
    }

    public void setMounth(Object mounth) {
        this.mounth = mounth;
    }

    public Object getNose() {
        return nose;
    }

    public void setNose(Object nose) {
        this.nose = nose;
    }

    public Object getHand() {
        return hand;
    }

    public void setHand(Object hand) {
        this.hand = hand;
    }

    public Object getFeet() {
        return feet;
    }

    public void setFeet(Object feet) {
        this.feet = feet;
    }

    public Object getHead() {
        return head;
    }

    public void setHead(Object head) {
        this.head = head;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
