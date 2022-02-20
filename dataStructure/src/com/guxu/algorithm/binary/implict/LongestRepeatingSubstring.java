package com.guxu.algorithm.binary.implict;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/*
leetcode 1062. 最长重复子串
 */
public class LongestRepeatingSubstring {
    int res = 0;
    public int longestRepeatingSubstring(String s) {
        int l = 1, r = s.length() - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            boolean res = LenKRes(s, mid);
            if (res) l = mid + 1;
            else r = mid - 1;
        }
        return res;
    }

    private boolean LenKRes(String s, int k) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            if (!seen.add(s.substring(i, i + k))) {
                res = Math.max(res, k);
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        String s = "abbaba";
        System.out.println(longestRepeatingSubstring(s));
    }
}
