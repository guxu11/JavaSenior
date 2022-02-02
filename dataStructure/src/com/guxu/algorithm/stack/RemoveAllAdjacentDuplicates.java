package com.guxu.algorithm.stack;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 1209. 删除字符串中的所有相邻重复项 II
 */
public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 ||  sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(1);
            } else {
                int increment = stack.pop() + 1;
                if (increment == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else stack.push(increment);
            }
        }
        return sb.toString();

    }

    @Test
    public void test() {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        String res = removeDuplicates(s, k);
        System.out.println(res);

    }
}
