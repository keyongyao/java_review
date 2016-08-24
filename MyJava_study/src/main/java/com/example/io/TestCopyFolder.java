package com.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/8/7.
 */
public class TestCopyFolder {

    void test(File src, File dst) {
        testCopyFolders(src, dst);
    }


    void testCopyFolders(File src, File dst) {
        if (src.isFile()) {
            copyFile(src, dst);
        } else if (src.isDirectory()) {
            dst.mkdirs();
            for (File sub : src.listFiles()
                    ) {
                testCopyFolders(sub, new File(dst, sub.getName()));
            }
        }
    }

    void copyFile(File src, File dst) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(src);
            outputStream = new FileOutputStream(dst);
            int len = 0;
            byte[] temp = new byte[4096];
            while (-1 != (len = inputStream.read(temp))) {
                outputStream.write(temp);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dst != null)
                    outputStream.close();
                if (src != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
