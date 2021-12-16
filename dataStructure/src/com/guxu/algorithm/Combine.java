package com.guxu.algorithm;
import org.testng.annotations.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

/*
leetcode 77 组合
 */

public class Combine {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        Deque<Integer> track = new ArrayDeque<>();
        if (n == k) {
            for (int i = 1; i <= n; i++) track.addLast(i);
            res.add(new ArrayList<>(track));
            return res;
        }
        backtrack(n, k, 1, track);
        return res;
    }
    private void backtrack(int n,  int k, int startIndex, Deque<Integer> track) {
        if (track.size() == k) {
            res.add(new ArrayList<Integer>(track));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
//            if (!track.isEmpty() && track.peek() >= i) continue;
            track.addLast(i);
            backtrack(n, k,i + 1, track);
//            System.out.println(track);
            track.removeLast();
        }
    }
    @Test
    public void test() {
        combine(4, 2);
        System.out.println(res);
    }
}
