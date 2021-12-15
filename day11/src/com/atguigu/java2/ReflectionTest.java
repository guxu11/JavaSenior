package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class ReflectionTest {
    @Test
    public void test() {
       float f = 1.2f;
       double d = 1.2d;
       int ab = 010;
        System.out.println(ab);
        f++;
       d+=1;
        System.out.println(d);
        System.out.println(f);
        String a = "100";
        System.out.println(Character.isDigit(a.charAt(0)));
    }
    @Test
    public void testField() throws Exception {
        Class clazz = Person.class;
        // 创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        // 获取指定的属性: 要求属性声明为public
        Field id = clazz.getField("id");
        // 设置当前属性的值
        // set(): 参数1：指明哪个对象 参数2：设置为多少
        id.set(p, 1001);
        int id1 = (int)id.get(p);
        System.out.println(id1);
    }
    @Test
    public void testStaticField() throws Exception{
        Class clazz =  Person.class;
        Field id = clazz.getDeclaredField("sId");
        id.setAccessible(true);
        id.set(Person.class, 100);
        System.out.println(id.get(clazz));
    }

    @Test
    public void testField1() throws Exception{
        Class clazz = Person.class;
        Person p = (Person)clazz.newInstance();

        Field name = clazz.getDeclaredField("name");
        // 保证当前属性是可访问的
        name.setAccessible(true);
        name.set(p, "guxu");
        System.out.println(name.get(p));
        System.out.println(p);
    }
    /*
    * 获取制定方法
    * */
    @Test
    public void testMethod() throws Exception{
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();
        // 1. 获取指定的方法
        Method show = clazz.getDeclaredMethod("show", String.class);
        String nation =(String) show.invoke(p,  "CHN");
        System.out.println(nation);

        System.out.println("************如何调用静态方法***************");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object returnVal = showDesc.invoke(Person.class);
        System.out.println(returnVal);
    }

    @Test
    public void testConstructor() throws Exception{
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        // 用获取的构造器创建实例
        Person per = (Person) constructor.newInstance("ziyi");
        System.out.println(per);
    }
}
