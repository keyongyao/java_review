package com.example.collection;

import java.util.Date;

/**
 * 自己实现的ArrayList 类
 * Created by Administrator on 2016/7/25.
 */
public class MyArrayList {
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initalCapacity) {
        if (initalCapacity <= 0)
            throw new IllegalArgumentException("IllegalArgument:" + initalCapacity);
        elementData = new Object[initalCapacity];

    }

    public void add(Object o) {
        ensureCapcity();
        elementData[size++] = o;
    }

    private void ensureCapcity() {
        if (size == elementData.length) {
            Object[] tmpArray = new Object[size * 2];
            System.arraycopy(elementData, 0, tmpArray, 0, elementData.length);
            elementData = tmpArray;
        }
    }

    public int getSize() {
        return size;
    }

    public void test() {
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add("sdfadsf");
        myArrayList.add("asdfdsf");
        myArrayList.add("asdfdsafdsf");
        myArrayList.add(new Date().toString());
        System.out.print(myArrayList.getSize());


    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("IllegalArgument:" + index);
        }
        return elementData[index];
    }

    public boolean remove(int index) {
        int moveNUm = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, moveNUm);
        elementData[--size] = null;
        return true;
    }

    public boolean remove(Object o) {
        for (int index = 0; index < size; index++) {
            if (o.equals(elementData[index])) {
                remove(index);
            }
            return true;
        }
        return false;
    }

    public Object set(int index, Object o) {
        //TODO rangCheck(index)
        Object oldElement = elementData[index];
        elementData[index] = o;
        return oldElement;
    }

    public void add(int index, Object o) {
        // TODO rangCheck(index)
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = o;
        size++;
    }
}
