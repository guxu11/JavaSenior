package com.atguigu.java;

import org.junit.Test;

/**
 * @author: guxu
 * @create: 2021/11/8
 * @description:
 */
public class StringBufferBuildTest {
    @Test
    public void test() {
        StringBuffer sb1 = new StringBuffer(20);
        for (int i = 0; i < 10; i++) {
            sb1.append(String.valueOf(i));
        }
        System.out.println(sb1.toString());
        System.out.println("***********");
        sb1.delete(0, 2);
        System.out.println(sb1.toString());
        sb1.reverse();
        System.out.println(sb1.toString());

    }
//    public static void main(String[] args) {
//        int a = 19;
//        System.out.println(a << 1);
//    }
}
