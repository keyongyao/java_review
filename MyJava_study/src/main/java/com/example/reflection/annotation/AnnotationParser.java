package com.example.reflection.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 处理注释annotation，使用反射机制
 * Created by Administrator on 2016/8/14.
 */
public class AnnotationParser {
    void run() {
        try {
            Class<?> aClass = Class.forName("com.example.reflection.annotation.StudentBean"); //从JVM获取studentBean类的模板
            Annotation[] annotations = aClass.getAnnotations(); //获取这个类的注释集
            for (Annotation tmp : annotations
                    ) {
                System.out.println(tmp);
            }
            //获取类置顶的注释
            AnnotationTable table = aClass.getAnnotation(AnnotationTable.class);
            System.out.println(table.value());

            //获取类的字段的注释
            Field field = aClass.getDeclaredField("name");
            AnnotationField annotationField = field.getAnnotation(com.example.reflection.annotation.AnnotationField.class);
            /*for (Annotation tmp:field.getAnnotations()
                 ) {
                System.out.println(tmp);
            }*/
            //打印注释的属性
            System.out.println(annotationField.columnName());
            System.out.println(annotationField.length());
            System.out.println(annotationField.type());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
