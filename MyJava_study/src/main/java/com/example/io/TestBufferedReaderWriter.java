package com.example.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 优化以及转码
 * Created by Administrator on 2016/8/7.
 */
public class TestBufferedReaderWriter {
    void test() {
        File src = new File("d:/dirs.txt");
        File dst = new File("d:/dirs_copy.txt");

        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(src), "GBK"));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dst, true), "UTF-8"));
            // char[] arry = new char[4];
            //int len = 0;
            String line = null;
            while (null != (line = reader.readLine())) {
                //   System.out.println("<------->"+len);
                // System.out.print(arry);
                System.out.println(line);

                writer.write(line);  //写一行
                writer.newLine();  //添加一个回车和换行
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (reader != null)
                    reader.close();
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
