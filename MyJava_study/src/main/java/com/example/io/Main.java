package com.example.io;

import java.io.File;

/**
 * Created by Administrator on 2016/8/6.
 */
public class Main {
    public static void main(String[] str) {
        //new TestFile().read();
//        new TestFile().testTemp();
        // new TestDir().read();
        // new TestDir().testList();
        // new TestDir().testFileNamefilter();
        // new TestDir().listDirs("N:/Java_开发/尚学堂JAVA高淇_300集/");
        // new TestFileInputStream().read();
        //  new TestOutputStream().read();
        //  new TestCopyFile().testCopy();
        //  new TestCopyFolder().read(new File("D:\\360驱动大师目录"),new File("D:\\360驱动大师目录_bak"));
        //  new TestCopyFolder().copyFile("d:/abc.txt","d:/acb.txt");
        // new TestReaderWritter().read();
        //  new TestBufferedReaderWriter().read();
        //  new TestByteArrayInputStream().read();
        //  new TestByteArrayReadWriteFile().write(new TestByteArrayReadWriteFile().read("D:\\dirs.txt"),"D:\\dirs_.txt");
        //    new TestDataInputStream().write("d:/data.out");
        //   new TestDataInputStream().read("d:/data.out");
        //  new TestPrintStream().test();
        //    new TestRandomAccessFile().test();

        //   TestSplitFile testSplitFile=new TestSplitFile("D:\\TestFileInputStream.java");
        // new  TestSplitFile("D:/TestFileInputStream.java").splitFile(new File("D:/TestFileInputStream.java"));
        new TestMergFiles().test(new File("D:/blockpath.txt"));

    }
}
