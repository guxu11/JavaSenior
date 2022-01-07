package com.guxu.algorithm.memoSearch;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/*
leetcode 377 组合总和4
 */
public class Combine4 {
    Map<Integer, Integer> memo = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int target) {
        if (target == 0) return 1;
        if (memo.containsKey(target)) return memo.get(target);
        int res = 0;
        for (int num: nums) {
            if (num <= target) {
                res += dfs(nums, target - num);
            }
        }
        memo.put(target, res);
        return res;

    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        int target = 4;
        int res = combinationSum4(nums, target);
        System.out.println(res);
        System.out.println(memo);
    }
}
