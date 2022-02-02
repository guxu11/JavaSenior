package com.guxu.algorithm.stack;

import org.testng.annotations.Test;

import java.util.Stack;

/*
leetcode 1249 移除无效的括号
 */
public class MinimumMoveParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        int leftCount = 0, rightCount = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.push(i);
                leftCount++;
            } else if (sb.charAt(i) == ')') {
                if (rightCount == leftCount) {
                    sb.deleteCharAt(i);
                    i = i - 1;
                } else {
                    stack.pop();
                    rightCount++;
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
    @Test
    public void test() {
        String s = "a)b(c)d";
        System.out.println("res: " + minRemoveToMakeValid(s));

        StringBuilder sb = new StringBuilder("abc");
        sb.deleteCharAt(1);
        System.out.println(sb.charAt(1));
    }
}
