package com.example.javaassist;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * Created by Administrator on 2016/8/14.
 */
public class Main {
    public static void main(String[] args) {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("com.example.javaassist.test.Emp");

        try {
            // 构建属性
            CtField empname = CtField.make("private int id;", cc);
            CtField empid = CtField.make("private String name;", cc);
            cc.addField(empname);
            cc.addField(empid);
            //构建方法
            CtMethod getName = CtMethod.make("public String getName(){return name;}", cc);
            CtMethod getId = CtMethod.make("public int getID(){return id;}", cc);
            cc.addMethod(getId);
            cc.addMethod(getName);
            CtMethod setID = CtMethod.make("public void setID(int id){this.id=id;}", cc);
            CtMethod setName = CtMethod.make("public void setName(String  name){this.name=name;}", cc);
            cc.addMethod(setID);
            cc.addMethod(setName);
            //构建构造器
            CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")}, cc);
            constructor.setBody("{this.name=name;this.id=id;}");
            cc.addConstructor(constructor);
            cc.writeFile("c:/java");

        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
