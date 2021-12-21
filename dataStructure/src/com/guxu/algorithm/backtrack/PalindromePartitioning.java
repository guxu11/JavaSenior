package com.guxu.algorithm.backtrack;

/*
* leetcode 131 分割回文串
*/

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PalindromePartitioning {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        Deque<String> track = new ArrayDeque<>();
        backtrack(s, track, 0);
        return res;
    }

    private void backtrack(String s, Deque<String> track, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (!isValid(s, startIndex, i)) continue;
            track.addLast(s.substring(startIndex, i + 1));
            System.out.println(track);
            backtrack(s, track, i + 1);
            track.removeLast();
        }
    }

    private boolean isValid(String s, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
    @Test
    public void test(){
        partition("aba");
        System.out.println(res);
    }
}
