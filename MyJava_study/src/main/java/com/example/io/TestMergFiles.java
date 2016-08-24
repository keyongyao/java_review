package com.example.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Administrator on 2016/8/8.
 */
public class TestMergFiles {
    void test(File blockFile) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            String parentPath = blockFile.getParent();
            List<String> pathList = new ArrayList<>();
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(blockFile));
            while (null != (line = bufferedReader.readLine())) {
                pathList.add(line);
            } //read blockpath as List
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(parentPath, "mergFile.txt"), true));
            for (int i = 0; i < pathList.size(); i++) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(parentPath, pathList.get(i))));
                int len = 0;
                byte[] tmp = new byte[1024];
                while (-1 != (len = bufferedInputStream.read(tmp))) {
                    bufferedOutputStream.write(tmp, 0, len);
                }
                bufferedOutputStream.flush();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedOutputStream != null)
                    bufferedOutputStream.close();
                if (bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void test2(File blockFile) {
        BufferedOutputStream bufferedOutputStream = null;
        Vector<InputStream> streamVector = new Vector<>();
        SequenceInputStream sequenceInputStream = new SequenceInputStream(streamVector.elements());
        try {
            String parentPath = blockFile.getParent();
            List<String> pathList = new ArrayList<>();
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(blockFile));
            while (null != (line = bufferedReader.readLine())) {
                pathList.add(line);
            } //read blockpath as List
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(parentPath, "mergFile.txt"), true));
            for (int i = 0; i < pathList.size(); i++) {
                streamVector.add(new BufferedInputStream(new FileInputStream(new File(parentPath, pathList.get(i)))));

            }
            int len = 0;
            byte[] tmp = new byte[1024];
            while (-1 != (len = sequenceInputStream.read(tmp))) {
                bufferedOutputStream.write(tmp, 0, len);
            }
            bufferedOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedOutputStream != null)
                    bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
