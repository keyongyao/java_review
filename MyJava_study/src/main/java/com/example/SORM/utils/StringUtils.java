package com.example.SORM.utils;

/**
 * 字符串处理工具
 * Created by Administrator on 2016/8/24.
 */
public class StringUtils {
    public static String toUpperLetter(String word) {
        // word=word.toLowerCase();
        char[] chars = word.toCharArray();
        chars[0] = (char) (chars[0] - 32);
        return new String(chars);
    }
}
