package com.atguigu.java;

import org.junit.Test;

public class ClassLoaderTest {
    @Test
    public void test1() {
        // 自定义类，用系统加载器进行加载 返回sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);

        // 系统类加载器的parent 是扩展类加载器，返回sun.misc.Launcher$ExtClassLoader@24d46ca6
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        // 扩展类加载器的parent是引导类加载器，无法获取，返回null
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        // String 是java核心类库，用引导类加载器加载，所以获取不到，返回null
        System.out.println(String.class.getClassLoader());
    }

    @Test
    public void test2() {

    }
}

