package com.atguigu.java2;

import org.junit.Test;
import com.atguigu.java1.*;

import javax.swing.plaf.metal.MetalTheme;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class MethodTest {

    @Test
    public void test1() {
        Class<Person> cla = Person.class;
        Method[] methods = cla.getMethods();
        for (Method m: methods) {
            System.out.println((m));
        }

        System.out.println();
        Method[] methods1 = cla.getDeclaredMethods();
        for (Method m: methods1) {
            System.out.println(m);
        }
    }


    @Test
    public void test2() {
        Class cla = Person.class;
        Method[] methods = cla.getDeclaredMethods();
        for (Method m: methods) {
            // 1. 获取方法声明的注解,只能获取生命周期为RUNTIME的
            Annotation[] annos = m.getAnnotations();
            for (Annotation a: annos) {
                System.out.print(a + "\n");
            }
            // 2. 权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + " ") ;
            // 3. 返回值类型
            System.out.print(m.getReturnType().toString() + " ");
            // 4. 方法名
            System.out.print(m.getName() + " ");
            System.out.print("(");
            // 5. 形参列表
            Class[] params = m.getParameterTypes();
            if (!(params == null && params.length == 0)) {
                for (int i = 0; i < params.length; i++) {
                    if (i == params.length - 1) {
                        System.out.print(params[i].getName() +  " args_" + i);
                    } else {
                        System.out.print(params[i].getName() + " args_" + i + ", ");
                    }
                }
            }
            System.out.print(") ");
            // 6. 抛出的异常
            Class[] exceptions = m.getExceptionTypes();
            if ( exceptions.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptions.length; i++) {
                    if (i == exceptions.length - 1) {
                        System.out.print(exceptions[i].getName());
                        break;
                    }
                    System.out.print(exceptions[i].getName() + ", ");
                }
            }
            System.out.println();
        }

    }
}
