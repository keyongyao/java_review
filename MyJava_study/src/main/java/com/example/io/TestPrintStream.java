package com.example.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Administrator on 2016/8/7.
 */
public class TestPrintStream {
    void test() {
        PrintStream printStream = System.out;
        printStream.print("abc");

        try {
            //   printStream= new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("d:/log.txt"),true)));
            System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("d:/log.txt"), true)), true));
            System.out.println("asdfsdfdsf");
            System.out.println("asdfsdfdsf");
            System.out.println("asdfsdfdsf");
            System.out.println("asdfsdfdsf");
            System.out.println("asdfsdfdsf");

            System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
            System.out.println("aaaaaaaaaaaaaaaaa");
            System.out.println("aaaaaaaaaaaaaaaaa");
            System.out.println("aaaaaaaaaaaaaaaaa");
            System.out.println("aaaaaaaaaaaaaaaaa");
            System.out.println("aaaaaaaaaaaaaaaaa");
            System.out.println("aaaaaaaaaaaaaaaaa");
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
