package com.example.collection;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] str) {
        //  input your class
        // new MyArrayList().testHashBag();
        /*MyLinkedList myLinkedList= new MyLinkedList();
        myLinkedList.add("aaaaa");
        myLinkedList.add(new Date().toString());
        myLinkedList.add("bbbbbb");
        System.out.println(myLinkedList.getSize());
        System.out.println(myLinkedList.getNode(1));
*/

        //  System.out.println(new String("asdfasd").hashCode());
        //    new TestHashSet().testHashBag();
        //  new TestGeneric().testHashBag();
//        int arry[]={123,43,23,11,9};
//        int sortArry[]=new TestBubble().testHashBag(arry);
        //    new Testproperties().testHashBag();
        //   new Testproperties().saveToFile();
        //  new Testproperties().readProperties();
        // new TestWeakHashMap().testHashBag();
        //  new TestWeakHashMap2().testHashBag();
        // new TestIdentifyHashMap().testHashBag();
        //      new TestEmueMap().testHashBag();
        // new TestCollectionSyncrinized().readOnly();
        //   new TestCollectionSyncrinized().oneElenment();
//        new TestIterableMap().testHashBag();
        //    new TestIteratorUniqFilter().testHashBag();
        // new TestIteratorFilter().testHashBag();
        // new TestIteratorLoop().testHashBag();
        //  new TestIteratorLoop().testArrayLoop();
        //        new TestBidiMap().testDualBidiMap();
        //    System.out.println("<-------------------->");
        //  new TestBidiMap().testDualHashBidiMap();
        // new TestBag().testHashBag();
        //System.out.println("<--------------->");
        // new TestBag().testTreeBag();
        //  new TestBag().testCountWord();
        // new TestSortTreeMap().test("N:\\Java_开发\\尚学堂JAVA高淇_300集");
        List<String> tmp = null;
        Collections.sort((tmp = new TestSortTreeMap().test("N:\\Java_开发\\尚学堂JAVA高淇_300集")), new TestSortTreeMap());
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("d:/dirs__.txt"))));
            for (int i = 0; i < tmp.size(); i++) {
                // System.out.println(tmp.get(i));
                bufferedWriter.write(tmp.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
