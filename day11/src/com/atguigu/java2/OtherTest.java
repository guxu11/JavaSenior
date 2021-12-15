package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import javax.lang.model.element.TypeElement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {
    @Test
    public void test1() {
        Class cla = Person.class;
        Constructor[] constructors = cla.getConstructors();
        for (Constructor c: constructors) {
            System.out.println(c);
        }

        System.out.println();

        Constructor[] constructors1 = cla.getDeclaredConstructors();
        for (Constructor c: constructors1) {
            System.out.println(c);
        }
        System.out.println();
    }
    /*获取运行时类的父类*/
    @Test
    public void test2() {
        Class cla = Person.class;
        // 不带泛型
        Class clazz = cla.getSuperclass();
        System.out.println(clazz);

        // 带泛型
        Type genericSuperClass = cla.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperClass;
        // 获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());

    }

    @Test
    public void test3() {
        Class cla = Person.class;
        Class[] clz = cla.getInterfaces();
        for (Class c: clz) {
            System.out.println(c);
        }
        System.out.println();
        Class superClass = cla.getSuperclass();
        Class[] superClassInterface = superClass.getInterfaces();
        for (Class c: superClassInterface) {
            System.out.println(c);
        }
    }

    @Test
    public void test4() {
        Class cla = Person.class;
        Package pkg = cla.getPackage();
        System.out.println(pkg);
    }

    @Test
    public void test5() {
        Class cla = Person.class;
        Annotation[] annotations = cla.getAnnotations();
        for (Annotation a: annotations) {
            System.out.println(a);
        }

    }
}
