package com.example.collection;

/**
 * Created by Administrator on 2016/7/27.
 */
public class Node {
    public Node() {

    }


    public Node(Node previours, Node next, Object obj) {
        this.previours = previours;
        next = next;
        this.obj = obj;
    }

    Node previours;
    Object obj;
    Node next;

    public Node getPreviours() {
        return previours;
    }

    public void setPreviours(Node previours) {
        this.previours = previours;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        next = next;
    }
}
