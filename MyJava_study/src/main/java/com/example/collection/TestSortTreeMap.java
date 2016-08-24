package com.example.collection;

import org.apache.commons.collections4.Predicate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Administrator on 2016/8/8.
 */
public class TestSortTreeMap implements java.util.Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] a = o1.split("_");
        String[] b = o2.split("_");

        return new Integer(a[0]) > new Integer(b[0]) ? 1 : -1;
    }

    List<String> test(String folderPath) {
        File parenFolder = new File(folderPath);
        File[] subs = null;
        if (parenFolder.isDirectory()) {
            subs = parenFolder.listFiles();
        }
        List<String> subName = new ArrayList<>();

        for (File tmp : subs
                ) {
            if (tmp.isFile() && tmp.getName().contains("尚学堂") && !tmp.getName().endsWith(".pdf")) {
                String[] abc = tmp.getName().split("_");
                //System.out.println(abc[0]);
                subName.add(tmp.getName());
            }
        }
        return subName;


    }


}
