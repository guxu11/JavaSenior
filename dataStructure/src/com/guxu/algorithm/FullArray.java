package com.guxu.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.testng.annotations.Test;

public class FullArray {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }

    @Test
    public void test1() {
        List<Integer> l1 = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            l1.add(i);
        }
        System.out.println(new LinkedList<Integer>(l1));
    }
}
