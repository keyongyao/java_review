package com.example.SORM.utils;

import com.example.SORM.bean.TableInfo;
import com.example.SORM.core.DBmanager;
import com.example.SORM.core.TableContent;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/25.
 */
public class SrcFileWriteOut {


    public void write(StringBuilder builder, String dir, String name) {
        String s = builder.toString();
        BufferedOutputStream outputStream = null;
        try {
            //清除旧的java文件
            if ((new File(dir, name).exists())) {
                new File(dir, name).delete();
            }
            outputStream = new BufferedOutputStream(new FileOutputStream(new File(dir, name)));
            outputStream.write(s.getBytes(), 0, s.getBytes().length);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateSrcFiles() {
        String predir = DBmanager.connectionConfig.getPoPackage().replaceAll("\\.", "\\\\");
        String dir = DBmanager.connectionConfig.getSrcPath() + predir + "";

        for (TableInfo ti : TableContent.getDatabaseTablesMap().values()
                ) {
            CreateSrcFileUtils createSrcFileUtils = new CreateSrcFileUtils(ti);
            String name = StringUtils.toUpperLetter(createSrcFileUtils.getTableName()) + ".java";
            new SrcFileWriteOut().write(createSrcFileUtils.createClassBody(), dir, name);
        }
    }

    /*public static void main(String[] args) {
            updateSrcFiles();
    }*/
}
