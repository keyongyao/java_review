package com.example.javaassist;

import java.io.IOException;
import java.util.Arrays;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * 测试javaassist的API
 * Created by Administrator on 2016/8/15.
 */
public class TestJavaAssistAPI {
    static void test() {

        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass ctClass = pool.get("com.example.javaassist.Emp");
            byte[] bytes = ctClass.toBytecode();
            System.out.println(new String(bytes));
            System.out.println(Arrays.toString(bytes));

            System.out.println(ctClass.getName());
            System.out.println(ctClass.getSimpleName());
            System.out.println(ctClass.getSuperclass());
            System.out.println(ctClass.getPackageName());
            System.out.println(ctClass.getURL());

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }

}
