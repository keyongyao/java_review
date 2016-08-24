package com.example.io;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * 分割文件实现
 * Created by Administrator on 2016/8/7.
 */
public class TestSplitFile {
    public String fileName;
    public long blockSize;
    public int size;
    public List<String> blockPath;

    public TestSplitFile(String fileNmae, long blockSize) {
        this();
        this.fileName = fileNmae;
        this.blockSize = blockSize;
    }


    public TestSplitFile() {
        blockPath = new ArrayList<>();
    }


    public TestSplitFile(String fileNmae) {
        this();
        blockSize = 256;
        this.fileName = fileNmae;
        init();
    }

    public void init() {
        File src = null;
        if (fileName == null || !(src = new File(fileName)).exists() || src.isDirectory()) {
            return;
        }
        long fileLength = src.length();
        if (this.blockSize > fileLength)
            this.blockSize = fileLength;
        size = (int) Math.ceil(fileLength * 1.0 / blockSize);
        initBlockPath(src);


    }

    private void initBlockPath(File file) {
        for (int i = 0; i < this.size; i++) {
            this.blockPath.add(file.getName() + "-" + i + "-.part");
        }
    }

    public void splitFile(File fileName) {
        long beginPos = 0;
        long actualBlockSize = blockSize;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                actualBlockSize = fileName.length() - beginPos;
            }

            doSplitFile(fileName, i, beginPos, actualBlockSize);
            beginPos += actualBlockSize;
        }
        File blockPathFile = new File(fileName.getParent(), "blockpath.txt");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(blockPathFile)));
            for (String path : blockPath
                    ) {
                bufferedWriter.write(path);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void doSplitFile(File file, int block, long beginPos, long actaulBlockSize) {
        File dst = new File(file.getParent() + this.blockPath.get(block));
        RandomAccessFile randomAccessFile = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dst));
            randomAccessFile.seek(beginPos);
            byte[] flush = new byte[1024];
            int len = 0;
            while (-1 != (len = randomAccessFile.read(flush))) {
                if (actaulBlockSize >= len) {
                    bufferedOutputStream.write(flush, 0, len);
                    bufferedOutputStream.flush();
                    actaulBlockSize -= len;
                } else {
                    bufferedOutputStream.write(flush, 0, (int) actaulBlockSize);
                    bufferedOutputStream.flush();
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedOutputStream != null)
                    bufferedOutputStream.close();
                if (randomAccessFile != null)
                    randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
