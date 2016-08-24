package com.example.dynamicCompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * Created by Administrator on 2016/8/14.
 */
public class Main {
    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, "d:/java.java");
    }
}
