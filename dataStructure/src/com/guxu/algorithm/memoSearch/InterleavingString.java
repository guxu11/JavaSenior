package com.guxu.algorithm.memoSearch;

import org.testng.annotations.Test;

/*
leetcode 97 交错字符串
 */
public class InterleavingString {
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        memo = new int[s1.length() + 1][s2.length() + 1];
        return backtrace(s1, s2, s3, 0, 0, 0);
    }

    private boolean backtrace(String s1, String s2, String s3, int i, int j, int k) {
        if (memo[i][j] != 0) return memo[i][j] == 1;
        if (k == s3.length()) return true;
        boolean isValid = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) isValid = backtrace(s1, s2, s3, i + 1, j, k + 1);
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) isValid = isValid || backtrace(s1, s2, s3, i, j + 1, k + 1);
        if (isValid) memo[i][j] = 1;
        else memo[i][j] = -1;
        return isValid;
    }

    @Test
    public void test() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
