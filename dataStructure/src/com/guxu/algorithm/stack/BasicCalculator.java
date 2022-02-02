package com.guxu.algorithm.stack;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

/*
leetcode 224 基本计算器
 */
public class BasicCalculator {
    public int calculate(String s) {
        s = "(" + s + ")";
        Deque<Integer> nums = new LinkedList<>();
        Deque<Integer> signs = new LinkedList<>();
        int sign = 1;
        int sum = 0;
        int currNumber = 0;
         for (int i = 0; i < s.length(); i++) {
             if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                 sign = s.charAt(i) == '+' ? 1 : -1;
             } else if (Character.isDigit(s.charAt(i))) {
                 currNumber = currNumber * 10 + (s.charAt(i) - '0');
                 if (i < s.length() - 1 && !Character.isDigit(s.charAt(i + 1))) {
                     sum += currNumber * sign;
                     currNumber = 0;
                 }
             } else if (s.charAt(i) == '(') {
                 nums.push(sum);
                 signs.push(sign);
                 sum = 0;
                 sign = 1;
             } else if (s.charAt(i) == ')') {
                 sign = signs.pop();
                 sum = nums.pop() + sign * sum;
                 System.out.println("sum = " + sum + ", sign = "+ sign);
             }
         }
         return sum;
    }

    @Test
    public void test() {
        String s = "(1+(4+5+2)-3)+(6+8)";
        int res = calculate(s);
        System.out.println(res);
    }
}
