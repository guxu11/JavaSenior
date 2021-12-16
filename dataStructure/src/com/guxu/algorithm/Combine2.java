package com.guxu.algorithm;

import org.testng.annotations.Test;

import java.util.*;
/*
leetcode 39 组和总和
 */
public class Combine2 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> track = new ArrayDeque<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, track, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, Deque<Integer> track, int startIndex) {
        if (getSum(track) == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (getSum(track) > target || candidates[i] > target) continue;
            track.addLast(candidates[i]);
            backtrack(candidates, target, track, i);
            track.removeLast();
        }
    }
    private int getSum(Deque<Integer> deque) {
        int sum = 0;
        for (int i: deque) {
            sum += i;
        }
        return sum;
    }
    @Test
    public void test() {
        int[] can = {2,3,6,7};
        int tar = 7;
        combinationSum(can, tar);
        System.out.println(res);
    }
}
