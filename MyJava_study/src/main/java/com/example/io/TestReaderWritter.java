package com.example.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 可用于读取 txt html 等纯文本的读取
 * Created by Administrator on 2016/8/7.
 */
public class TestReaderWritter {
    void test() {
        File src = new File("d:/dirs.txt");
        File dst = new File("d:/dirs_copy.txt");
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(src);
            writer = new FileWriter(dst, true);
            char[] arry = new char[4];
            int len = 0;
            while (-1 != (len = reader.read(arry))) {
                //   System.out.println("<------->"+len);
                // System.out.print(arry);
                writer.write(arry);
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
