package com.guxu.algorithm.twopointers.samedirction;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
leetcode 76. 最小覆盖子串
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int left = 0, right = 0;
        int[] index = {0, n};
        char[] chars = s.toCharArray();
        int[] needs = new int[128];
        for (char c: t.toCharArray()) {
            needs[c]++;
        }
        int needCnt = m;
        while (right < n) {
            if (needs[chars[right]] > 0) {
                needCnt--;
            }
            needs[chars[right]]--;
            if (needCnt == 0){
                while (left < right && needs[chars[left]] < 0) {
                    needs[chars[left]]++;
                    left++;
                }
                if (right - left < index[1] - index[0]) {
                    index[1] = right;
                    index[0] = left;
                }
                needs[chars[left]]++;
                left++;
                needCnt++;
            }
            right++;
        }
        return index[1] == n ? "":s.substring(index[0], index[1] + 1);
    }

    @Test
    public void test() {
        String s = "A";
        String t = "B";
        System.out.println(minWindow(s, t));
    }
}
