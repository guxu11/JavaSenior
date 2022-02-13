package com.guxu.algorithm.backtrace;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/*
78. 子集
 */
public class Subsets1 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track, 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track, int startIndex) {
//        if (track.size() == nums.length) return;
        res.add(new ArrayList<>(track));
        for (int i = startIndex; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, track, i + 1);
            track.remove(track.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {};
        subsets(nums);
        System.out.println(res);
    }
}
