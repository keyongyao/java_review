package com.example.collection;

/**
 * Created by Administrator on 2016/7/31.
 */
public class TestBubble {

    public int[] test(int[] abc) {
        int tmp;
        int time = 0;

        // from small to big
        for (int i = 0; i < abc.length; i++) {

            for (int j = i + 1; j < abc.length; j++) {
                if (abc[i] > abc[j]) {
                    tmp = abc[i];
                    abc[i] = abc[j];
                    abc[j] = tmp;
                }
                time += 1;
                for (int a : abc) {
                    System.out.print(a + " ");
                }
                System.out.println();

            }


        }
        System.out.println("exchang times: " + time);
        return abc;
    }

}
