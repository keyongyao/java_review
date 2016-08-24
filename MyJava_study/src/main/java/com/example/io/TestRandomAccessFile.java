package com.example.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2016/8/7.
 */
public class TestRandomAccessFile {
    void test() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File("d:/log.txt"), "r");
            randomAccessFile.seek(50);
            int len = 0;
            byte[] temp = new byte[1024];
            while (-1 != (len = randomAccessFile.read(temp))) {
                System.out.println(new String(temp, 0, len));
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
