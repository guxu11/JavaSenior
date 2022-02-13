package com.guxu.algorithm.backtrace;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 47 全排列2 数组有相同元素
 */
public class FullArrayUnique {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        if (n == 0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[n];
        Deque<Integer> track = new ArrayDeque<>();
        backtrack(n,  track, nums, used);
        return res;
    }
    private void backtrack(int n, Deque<Integer> track, int[] nums, boolean[] used) {
        if (n == track.size()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            track.addLast(nums[i]);
            used[i] = true;
            backtrack(n,  track, nums, used);
            used[i] = false;
            track.removeLast();
        }
    }

    @Test
    public void test() {
        int[] nums = {1,1,2};
        List<List<Integer>> r = permuteUnique(nums);
        System.out.println(r);
    }
}
