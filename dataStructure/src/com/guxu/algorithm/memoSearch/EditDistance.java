package com.guxu.algorithm.memoSearch;

import org.testng.annotations.Test;

import java.util.Arrays;

/*
leetcode 72 编辑距离
 */
public class EditDistance {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        memo = new int[m + 1][n + 1];
        for(int[] me: memo) Arrays.fill(me, -1);
        return dfs(word1, word2, word1.length(), word2.length());

    }

    private int dfs(String word1, String word2, int m, int n) {
        if (memo[m][n] != -1) return memo[m][n];
        if (m == 0 || n == 0) {
            memo[m][n] = Math.max(m, n);
            return Math.max(m, n);
        }
        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            int res = dfs(word1, word2, m - 1, n - 1);
            memo[m][n] = res;
            return res;
        }
        int res =  1 + Math.min(Math.min(
                    dfs(word1, word2, m - 1, n),  // 删除
                    dfs(word1, word2, m, n - 1)          // 添加
            ),      dfs(word1, word2, m - 1, n - 1)         // 替换
            );
        memo[m][n] = res;
        return res;
    }



    @Test
    public void test() {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));

    }
    @Test
    public void test1() {
        String s = "123";
        System.out.println(s.substring(1, 1).equals(""));
    }
}
