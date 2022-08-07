package com.guxu.algorithm;

import org.testng.annotations.Test;

/*
leetcode 43. 字符串相乘
 */
public class StringMultiple {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0 ; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                res[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i >= 1; i--) {
            res[i - 1] += res[i] / 10;
            res[i] %= 10;
        }
        int index = res[0] == 0 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < m + n; i++) {
            stringBuilder.append(res[i]);
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
        System.out.println(123 * 456);
    }
}
