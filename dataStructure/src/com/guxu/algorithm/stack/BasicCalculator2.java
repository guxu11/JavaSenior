package com.guxu.algorithm.stack;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
leetcode 227 基本计算器2
 */
public class BasicCalculator2 {
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
    }};
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        nums.push(0);
        Stack<Character> signs = new Stack<>();
        s = s.replace(" ", "");
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') signs.push(c);
            else if (c == ')') {
                while (!signs.isEmpty()) {
                    if (signs.peek() != '(') {
                        cal(nums, signs);
                    } else {
                        signs.pop();
                        break;
                    }
                }
            } else if (Character.isDigit(c)) {
                int j = i;
                int u = 0;
                while (j < n && Character.isDigit(s.charAt(j))) u = u * 10 + (s.charAt(j++) - '0');
                nums.push(u);
                i = j - 1;
            } else {
                if (i > 0 && (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '-' || s.charAt(i - 1) == '+')) nums.push(0);
                while (!signs.isEmpty() && signs.peek() != '(') {
                    char prev = signs.peek();
                    if (map.get(prev) >= map.get(c)) {
                        cal(nums, signs);
                    } else break;
                }
                signs.push(c);
            }
        }
        while (!signs.isEmpty()) cal(nums, signs);
        return nums.pop();
    }

    private void cal(Stack<Integer> nums, Stack<Character> signs) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (signs.isEmpty()) return;
        int a = nums.pop(), b = nums.pop();
        char sign = signs.pop();
        int res = 0;
        if (sign == '+') res = b + a;
        if (sign == '-') res = b - a;
        if (sign == '*') res = b * a;
        if (sign == '/') res = b / a;
        nums.push(res);
    }

    @Test
    public void test() {
        String a = "3+2*(-2+  1)";
        System.out.println(calculate(a));
    }

}
