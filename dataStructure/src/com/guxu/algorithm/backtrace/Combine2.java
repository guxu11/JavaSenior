package com.guxu.algorithm.backtrace;

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
        backtrack(candidates, target, track, 0, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, Deque<Integer> track, int startIndex, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum > target || candidates[i] > target) continue;
            track.addLast(candidates[i]);
            sum += track.getLast();
            backtrack(candidates, target, track, i, sum);
            sum -= track.getLast();
            track.removeLast();
        }
    }
    @Test
    public void test() {
        int[] can = {2,3,6,7};
        int tar = 8;
        combinationSum(can, tar);
        System.out.println(res);
    }
}
