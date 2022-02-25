package com.guxu.algorithm.twopointers.samedirction;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 3. 无重复字符的最长子串
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        Set<Character> map = new HashSet<>();
        int res = 0;
        while (right < n) {
            if (map.contains(chars[right])) {
                map.remove(chars[left]);
                left++;
            } else {
                map.add(chars[right]);
                res = Math.max(right - left + 1, res);
                right++;
            }
        }
        return  res;
    }

    @Test
    public void test() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
