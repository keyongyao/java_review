package com.example.GOF23.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 保存数据的集合
 * Created by Administrator on 2016/8/20.
 */
public class ConcreteContainer {
    List<Object> objectList = new ArrayList<>();
    private int curror;

    public List<Object> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Object> objectList) {
        this.objectList = objectList;
    }

    public int getCurror() {
        return curror;
    }

    public void setCurror(int curror) {
        this.curror = curror;
    }


    Object getCurrentObject() {
        return objectList.get(curror);
    }

    void addObject(Object o) {
        this.objectList.add(o);
    }

    void removeObject(Object o) {
        this.objectList.remove(o);
    }

    MyIterator getIterator() {
        return new InitIterator();
    }


    private class InitIterator implements MyIterator {
        @Override
        public boolean hasNext() {
            if (curror < objectList.size())
                return true;
            return false;
        }

        @Override
        public void previous() {
            if (!isFirst())
                curror--;
        }

        @Override
        public void next() {
            if (curror < objectList.size())
                curror++;
        }

        @Override
        public boolean isFirst() {
            if (curror == 0)
                return true;
            return false;
        }

        @Override
        public boolean isLast() {
            if (curror == objectList.size())
                return true;
            return false;
        }

        @Override
        public Object getCurentObject() {
            return objectList.get(curror);
        }
    }
}
