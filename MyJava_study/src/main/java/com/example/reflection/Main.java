package com.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by Administrator on 2016/8/14.
 */
public class Main {
    public static void main(String[] args) {
        String classpath = "com.example.reflection.UserBean";
        try {
            Class<?> aClass = Class.forName(classpath);
            Class<?> aClass1 = Class.forName(classpath);
            Class<? extends UserBean> aClass2 = new UserBean().getClass();
           /* System.out.println(aClass.hashCode());
            System.out.println(aClass1.hashCode());
            System.out.println(aClass2.hashCode());
            System.out.println(UserBean.class.hashCode());*/
            //获取的全名
            System.out.println(aClass.getName());
            //获取类名
            System.out.println(aClass.getSimpleName());

            System.out.println(aClass.getFields().length);  //获取公开字段
            System.out.println(aClass.getDeclaredFields().length); //获取全部字段
            //属性相关的操作
            for (Field ss : aClass.getDeclaredFields()
                    ) {
                System.out.println("属性：" + ss.getName() + " 属性类型：" + ss.getType());
            }
            //方法相关的操作
            for (Method ss : aClass.getDeclaredMethods()
                    ) {
                System.out.println("方法：" + ss.getName() + "  返回值： " + ss.getReturnType());
                for (Parameter parameters : ss.getParameters()
                        ) {
                    System.out.println("参数：" + parameters.getName() + " 参数类型：" + parameters.getType());
                }
            }
            //构造器的相关的操作
            for (Constructor<?> constructors : aClass.getConstructors()
                    ) {
                Constructor<?> abc = constructors;
                System.out.println(abc);
                for (Parameter parameters : abc.getParameters()
                        ) {
                    System.out.println("构造器：" + constructors + "  参数：" + parameters);
                }

            }
            //获取带参数的构造器，并创建对象

            Constructor<?> constructor = aClass.getDeclaredConstructor(int.class, String.class, int.class);
            UserBean bean = (UserBean) constructor.newInstance(10, "kyy", 30);
            System.out.println(bean.toString());

            //通过反射API调用方法
            UserBean user = (UserBean) aClass.newInstance();
            Method userMethod = aClass.getMethod("setUname", String.class);

            userMethod.invoke(user, "柯永耀");
            System.out.println(user.toString());
            //通过API设置属性

            Field age = aClass.getDeclaredField("age");
            age.setAccessible(true);  //使私有属性能被访问
            age.set(user, 23);
            System.out.println(age.get(user)); //通过反射API获取属性值
            System.out.println(user.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
