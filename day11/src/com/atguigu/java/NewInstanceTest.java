package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

public class NewInstanceTest {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> cla = Person.class;
        /*
        * newInstance(): 调用此方法，创建对应的运行时类对象。内部调用了运行时类的空参构造器
        * 要想此方法正常创=创建运行时类的对象，要求
        * 1. 运行时类必须提供空参构造器
        * 2. 空参构造器的访问权限要够，用场设置为public
        *
        *
        * 在JavaBean中要求提供一个public的空参构造器。原因：
        * 1. 便于通过反射，创建运行时类的对象
        * 2. 便于子类继承次运行时类时，默认调用super()时，保证有次构造器
        * */
        Person obj = cla.newInstance();
        System.out.println(obj);
    }

    @Test
    public void test2() {

        try {

            Object obj = null;
            for (int i = 0; i< 100; i++) {
                int num = new Random().nextInt(3);
                String classPath = "";
                switch (num) {
                    case 0:
                        classPath = "java.util.Date";
                        break;
                    case 1:
                        classPath = "java.lang.Object";
                        break;
                    case 2:
                        classPath = "com.atguigu.java.Person";
                        break;
                }
                obj = getInstance(classPath);
                System.out.println(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 常见一个指定类的对象
    public Object getInstance(String classPath) throws Exception{
        Class cla = Class.forName(classPath);
        return cla.newInstance();
    }
}
