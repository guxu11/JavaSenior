package com.guxu.algorithm.backtrack;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
216. 组合总和 III
 */

public class Combine4 {
    private List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[9];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = i + 1;
        }
        List<Integer> track = new ArrayList<>();
        backtrack(candidates, k, n, 0, 0, track);
        return res;
    }

    private void backtrack(int[] candidates, int k, int n, int sum, int currIndex, List<Integer> track) {
        if (sum == n && track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = currIndex; i < candidates.length; i++) {
            if (sum > n || track.size() > k || candidates[i] > n) break;
            sum += candidates[i];
            track.add(candidates[i]);
            backtrack(candidates, k, n, sum, i + 1, track);
            track.remove(track.size() - 1);
            sum -= candidates[i];
        }
    }

    @Test
    public void test() {
        int t, x, y;
        t = 3;
        x = y = 2;
        t = (x++) | (++y);
        System.out.println(t);

        combinationSum3(3, 9);
        System.out.println(res);
    }
}
