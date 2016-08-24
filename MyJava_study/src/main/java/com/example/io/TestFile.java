package com.example.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/6.
 */
public class TestFile {
    void test() {
       /* System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);

        String parentPath= "d:/abc";
        String childpPaht= "/d.jpg";


        System.out.println(new File(parentPath,childpPaht).getPath());
        System.out.println(new File(parentPath,childpPaht).getName());
        System.out.println(new File(parentPath,childpPaht).getParent());
        System.out.println(new File("abc").getPath());
        System.out.println(new File("abc").getName());
        System.out.println(new File("abc").getAbsolutePath());*/

      /*  String fileName = "N:\\Java_开发\\尚学堂JAVA高淇_300集\\189_尚学堂_裴新_java300集最全视频教程_网络编程_TCP_Socket通信_原理.mp4";
        File file= new File(fileName);
        System.out.println("file.getAbsolutePath() <----->"+file.getAbsolutePath());
        System.out.println("file.getName() <------->"+file.getName());
        System.out.println("file.getParent()  <------->"+file.getParent());
        System.out.println("file.getPath() <-------->"+file.getPath());
        System.out.println("file.getAbsoluteFile() <-------->"+file.getAbsoluteFile());

        System.out.println("<-------------separator--------------------->");

        System.out.println("file.exists() <------>"+file.exists());
        System.out.println("file.canExecute() <---------->"+file.canExecute());
        System.out.println("file.canRead()<----->"+file.canRead());
        System.out.println("file.canWrite()<------->"+file.canWrite());
        System.out.println("file.isFile() <------->"+file.isFile());
        System.out.println("file.isDirectory() <------>"+file.isDirectory());
        System.out.println("file.length()<-------->"+file.length()/1024/1024);*/

        String file = "d:/abc.txt";
        File file1 = new File(file);
        if (!file1.exists()) {
            boolean flag = false;
            try {
                flag = file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(flag ? "created successes" : " created failed");

        }
        if (file1.exists()) {
            System.out.println(file1.delete() ? "del successes" : "del failed");
        }
    }

    void testTemp() {
        File temp = null;
        try {
            temp = File.createTempFile("tmp", ".tmp", new File("d:/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
            temp.deleteOnExit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
