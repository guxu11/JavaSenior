package com.guxu.algorithm.twopointers.back;

import org.testng.annotations.Test;

/*
leetcode 5. 最长回文子串
 */
public class LongestPalindromicSubstring {
    // Solution1: 动态规划
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] interval = {0, 0};
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i == n - 1) break;
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = true;
                interval[0] = i;
                interval[1] = i + 1;
            }
        }
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                if (dp[i + 1][j - 1] && s.charAt(j) == s.charAt(i)) {
                    dp[i][j] = true;
                    if (j - i + 1 > interval[1] - interval[0] + 1) {
                        interval[1] = j;
                        interval[0] = i;
                    }
                }
            }
        }
        return s.substring(interval[0], interval[1] + 1);
    }

    // Solution2: 双指针
    public String twoPointer(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] interval = {0, 0};
        for (int i = 0; i < n; i++) {
            int[] oddInterval = findMaxInterval(chars, i, i);
            int[] evenInterval = findMaxInterval(chars, i, i+1);
            int[] longer = oddInterval[1] - oddInterval[0] > evenInterval[1] - evenInterval[0] ? oddInterval: evenInterval;
            interval = interval[1] - interval[0] > longer[1] - longer[0] ? interval : longer;
        }
        return s.substring(interval[0], interval[1] + 1);
    }

    private int[] findMaxInterval(char[] chars, int left, int right) {
        int[] res = new int[2];
        while (left >= 0 && right < chars.length) {
            if (chars[left] == chars[right]) {
                res[0] = left;
                res[1] = right;
                left--;
                right++;
            } else break;
        }
        return res;
    }
    // TODO: Solution3 Manacher

    @Test
    public void test() {
        String s = "aaaaa";
        System.out.println(twoPointer(s));
    }
}