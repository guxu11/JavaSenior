package com.atguigu.java;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    // 反射之前
    @Test
    public void test1() {
        Person p1 = new Person("Tom", 12);
        p1.age = 10;
        System.out.println(p1.toString());
        p1.show();
    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class cla = Person.class;

        // 1. 通过反射，创建Person类的对象
        Constructor cons = cla.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p);

        // 2. 通过反射，调用对象指定的属性，方法
        Field age = cla.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p);

        // 调方法
        Method show = cla.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("****************************");
        // 通过反射，可以调用Person类的私有成员
        Constructor cons1 = cla.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");

        // 调用私有属性
        Field name = cla.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "guxu");
        System.out.println(p1);
        // 调用私有方法
        Method showNation = cla.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);

        // 运行时类是Class的实例
    }
    // 获取Class实例的方式(前三种方式需要掌握)
    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一 调用运行时类的属性
        Class cla1 = Person.class;
        System.out.println(cla1);
        // 方式二 通过运行时类的对象
        Person p1 = new Person();
        Class cla2 = p1.getClass();
        System.out.println(cla2);
        // 方式三 通过Class 的 forName(String classPath)
        // 如果类不存在，编译时不会报错，运行时才会
        Class cla3 = Class.forName("com.atguigu.java.Person");
        System.out.println(cla3);

        System.out.println("*********判断三个对象地址是不是相同***********");
        System.out.println(cla1 == cla2);
        System.out.println(cla2 == cla3);
        // 方式四 使用类加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class cla4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(cla4);
    }
}


