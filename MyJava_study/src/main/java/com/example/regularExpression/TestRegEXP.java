package com.example.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/8/21.
 */
public class TestRegEXP {
    public static void main(String[] args) {
        String str = "dsf32423dfsg455bad#%#sfds#$#@$324";
        Pattern pattern = Pattern.compile("([^a-z]+)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());

        }
    }
}
