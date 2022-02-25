package com.guxu.algorithm.twopointers.samedirction;

import org.testng.annotations.Test;

/*
leetcode 424. 替换后的最长重复字符
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        int windowMax = 0;
        int res = 0;
        while (right < n) {
            map[chars[right] - 'A']++;
            windowMax = Math.max(windowMax, map[chars[right] - 'A']);
            if (right - left + 1 > windowMax + k) {
                map[chars[left] - 'A']--;
                left++;
            } else res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    @Test
    public void test() {
        String s = "B";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
