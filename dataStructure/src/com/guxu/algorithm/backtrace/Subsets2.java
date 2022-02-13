package com.guxu.algorithm.backtrace;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track, 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track, int startIndex) {
//        if (track.size() == nums.length) return;
        res.add(new ArrayList<>(track));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            track.add(nums[i]);
            backtrack(nums, track, i + 1);
            track.remove(track.size() - 1);
        }
    }
    @Test
    public void test() {
        int[] nums = {1,2,2};
        subsetsWithDup(nums);
        System.out.println(res);
    }
}
