package com.example.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Administrator on 2016/8/6.
 */
public class TestDir {
    String path = "d:/a/b/c";

    void test() {
        File dir = new File(path);
        //System.out.println(dir.mkdir()?true:false);
        System.out.println(dir.mkdirs() ? true : false);
        if (dir.exists())
            dir.delete();
    }

    void testList() {
        String dirs = "N:/Java_开发/尚学堂JAVA高淇_300集/";
        File file = new File(dirs);
        String[] arry = file.list();
        for (String name : arry
                ) {
            System.out.println(name);
        }
        System.out.println("<----------------------->");
        File[] file1 = file.listFiles();
        for (File temp : file1
                ) {
            System.out.println(temp.getAbsoluteFile());
        }
    }

    void testFileNamefilter() {
        String dir = "N:/Java_开发/尚学堂JAVA高淇_300集/";
        File file = new File(dir);
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).getName().contains("IO");
            }
        });
        for (File tmp : files
                ) {
            System.out.println(tmp.getName());
        }

    }

    void listDirs(String path) {
        if (null == path && !new File(path).exists())
            return;
        File file = new File(path);
        File[] arr = file.listFiles();
        for (File dir : arr
                ) {
            if (dir.isFile()) {
                System.out.println("\t" + dir.getName());
            } else if (dir.isDirectory()) {
                System.out.println(dir.getName());
                listDirs(dir.getAbsolutePath());
            }
        }
    }
}
