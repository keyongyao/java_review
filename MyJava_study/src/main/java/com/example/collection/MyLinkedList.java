package com.example.collection;

/**
 * Created by Administrator on 2016/7/26.
 */
public class MyLinkedList {

    private Node first;
    private Node last;
    private int size;

    public void add(Object o) {
        Node n = new Node();
        if (first == null) {
            n.setPreviours(null);
            n.setObj(o);
            n.setNext(null);

            first = n;
            last = n;
        } else {
            n.setPreviours(last);
            n.setObj(o);
            n.setNext(null);
            last.setNext(n);
            last = n;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public Object getNode(int index) {
        Node tmp;

        if (first != null && size > index) {
            tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp.obj;
        } else {
            return "null";
        }

    }


}
