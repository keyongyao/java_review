package com.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/8/6.
 */
public class TestFileInputStream {
    void test() {
        File file = new File("d:/abc.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] tmp = new byte[4096];
            int len = 0;
            while (-1 != (len = inputStream.read(tmp))) {
                String s = new String(tmp);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件没有找到！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输出输入流失败");
                }
        }


    }
}
