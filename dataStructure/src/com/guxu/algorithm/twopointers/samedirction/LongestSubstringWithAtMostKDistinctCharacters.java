package com.guxu.algorithm.twopointers.samedirction;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
leetcode 340. 至多包含 K 个不同字符的最长子串
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (k * n == 0) return 0;
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int res = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        while (right < n) {
            if (map.containsKey(chars[right]) || map.size() < k) {
                if (map.containsKey(chars[right])) {
                    map.remove(chars[right]);
                }
                map.put(chars[right], right);
                System.out.println(map);
                res = Math.max(res, right - left + 1);
                right++;
            } else {
                Map.Entry<Character, Integer> leftmost = map.entrySet().iterator().next();
                int index = leftmost.getValue();
                left = index + 1;
                map.remove(leftmost.getKey());
            }
        }
        return res;
    }

    @Test
    public void test() {
        String s=  "abaccc";
        int k =  2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }
}
