package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {

    @Test
    public void test1() {
        Class cla = Person.class;

        // 获取属性结构
        // 获取当前类和父类中声明为public的属性
        Field[] fields = cla.getFields();
        for(Field f: fields) {
            System.out.println(f);
        }
        System.out.println();

        // 只获取当前类，不获取父类
        Field[] fields1 = cla.getDeclaredFields();
        for (Field f: fields1) {
            System.out.println(f);
        }
    }

    @Test
    public void test2() {
        Class cla = Person.class;
        Field[] declaredFields = cla.getDeclaredFields();
        for (Field f: declaredFields) {
            // 1. 获取权限修饰符
            int modifier = f.getModifiers();
            System.out.println(Modifier.toString(modifier));

            // 2. 数据类型
            Class type = f.getType();
            System.out.println(type.getName() + "\t");
            // 3. 变量名
            String fName = f.getName();
            System.out.println(fName);
            System.out.println("**********************");
        }

    }
}
