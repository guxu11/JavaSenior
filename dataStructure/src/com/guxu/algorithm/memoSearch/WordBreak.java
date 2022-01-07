package com.guxu.algorithm.memoSearch;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
leetcode 139 单词拆分
 */
public class WordBreak {
    // 1. 记忆化搜索
    private int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        StringBuilder track = new StringBuilder();
         boolean res = backtrace(s, wordDict,  0);
        return res;
    }

    private boolean backtrace(String s, List<String> wordDict, int index) {
        if (index == s.length()) return true;
        if (memo[index] != -1) return memo[index] == 1;
        for (int i = index; i < s.length(); i++) {
            if (wordDict.contains(s.substring(index, i + 1)) && backtrace(s, wordDict, i + 1)) {
                memo[i] = 1;
                return true;
            }
        }
        memo[index] = 0;
        return false;
    }

    @Test
    public void test() {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }
    @Test
    public void test2() {
        StringBuilder sb = new StringBuilder("abcd");
        sb.delete(1, 4);
        System.out.println(sb);
    }
}
