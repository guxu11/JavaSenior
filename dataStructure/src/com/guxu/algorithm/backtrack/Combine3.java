package com.guxu.algorithm.backtrack;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
40. 组合总和 II
 */
public class Combine3 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> track = new ArrayList<>();
        backtrack(candidates, target, 0, track, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int sum, List<Integer> track, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum > target || candidates[i] > target) break;
            if (i > startIndex && candidates[i] == candidates[i - 1]) continue;
            sum += candidates[i];
            track.add(candidates[i]);
            backtrack(candidates, target, sum, track, i + 1);
            track.remove(track.size() - 1);
            sum -= candidates[i];
        }
    }

    @Test
    public void test() {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        combinationSum2(candidates, target);
        System.out.println(res);
    }
}
