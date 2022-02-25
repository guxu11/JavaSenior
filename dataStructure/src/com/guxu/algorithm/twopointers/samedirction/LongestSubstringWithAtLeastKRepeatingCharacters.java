package com.guxu.algorithm.twopointers.samedirction;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 395. 至少有 K 个重复字符的最长子串
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    private int res = 0;
    public int longestSubstring(String s, int k) {
        int n = s.length();
        maxLen(s, 0, n - 1, k);
        return res;
    }

    private void maxLen(String s, int left, int right, int k) {
        if (left > right) return;
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = left; i <= right; i++) {
            if (map.get(s.charAt(i)) < k) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            res = Math.max(res, right - left + 1);
            return;
        }
        Collections.sort(list);
        if (left != list.get(0)) maxLen(s, left, list.get(0) - 1, k);
        if (right != list.get(list.size() - 1)) maxLen(s, list.get(list.size() - 1) + 1, right, k);
        for (int i = 0; i < list.size() - 1; i++) {
            maxLen(s, list.get(i) + 1, list.get(i + 1) - 1, k);
        }
    }

    @Test
    public void test() {
        String s = "a";
        int k = 1;
        System.out.println(longestSubstring(s, k));
    }
}
