package com.guxu.algorithm;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 22 括号生成
 */
public class GenerateParentheses {
    private static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<String>();
        StringBuffer track = new StringBuffer();
        backtrack(n, n, track);
        return res;
    }
    private static void backtrack(int left, int right, StringBuffer track) {
        if (left == 0 && right == 0) {
            res.add(track.toString());
        }
        if (left > right) return;
        if (left > 0) {
            track.append("(");
            backtrack(left - 1, right, track);
            track.deleteCharAt(track.length() - 1);
        }
        if (right > 0) {
            track.append(")");
            backtrack(left, right - 1, track);
            track.deleteCharAt(track.length() - 1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(2);
    }

    public void test1(int [] a) {
        a[0] = 100;
    }
    @Test
    public void test() {
//        List<String> r = generateParenthesis(3);
//        System.out.println(r);
        int[] a = {1, 200, 300};
        test1(a);
        System.out.println(a[0]);
    }

}
