package com.example.GOF23.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2016/8/17.
 */
public class Main {
    public static void main(String[] args) {
       /* System.out.println(demo3.getInstance().hashCode());
        System.out.println(demo3.getInstance().hashCode());
        System.out.println(demo3.getInstance().hashCode());
        System.out.println(demo3.getInstance().hashCode());*/

        try {
            Class<?> aClass = Class.forName("com.example.GOF23.singleton.demo4");
            Constructor<?> constructor = aClass.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            /*System.out.println("========================");
            System.out.println(constructor.newInstance());
            System.out.println(constructor.newInstance());
            System.out.println(constructor.newInstance());
            System.out.println(constructor.newInstance());
            System.out.println("<>----------");*/

            //通过反序列化（先写到硬盘，再从硬盘去读对象，再新建对象），创建多个单例对象
            try {
                System.out.println("demo3的一个实例" + demo3.getInstance().hashCode() + "\n" + demo3.getInstance());
                FileOutputStream outputStream = new FileOutputStream("d:/object.class");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(demo3.getInstance());

                FileInputStream fileInputStream = new FileInputStream("d:/object.class");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                demo3 copy = (demo3) objectInputStream.readObject();
                demo3 replice = copy.clone();
                System.out.println(copy);
                System.out.println(replice.hashCode());

                // 得到2个不同实例

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        /**
         * 测试集中单例模式的执行效率
         */
        int threadCount = 10;

        CountDownLatch latch = new CountDownLatch(threadCount);  //线程同步的辅助类，用于同步子线程

        long start = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        demo4.getInstance();
                    }
                    latch.countDown();

                }
            }).start();

        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);


    }
}
