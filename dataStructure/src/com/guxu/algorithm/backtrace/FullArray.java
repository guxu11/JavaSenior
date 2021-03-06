package com.guxu.algorithm.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.testng.annotations.Test;

/*
leetcode 46 全排列1， 数组没有重复元素
 */
public class FullArray {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> trace = new ArrayList<>();
        backtrace(nums, trace);
        return res;
    }

    private void backtrace(int[] nums, List<Integer> trace) {
        if (trace.size() == nums.length) {
            res.add(new LinkedList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (trace.contains(nums[i])) continue;
            trace.add(nums[i]);
            backtrace(nums, trace);
            trace.remove(trace.size() - 1);
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
        int[] nums = {1,2,3};
        System.out.println(Arrays.copyOfRange(nums, 0, 0).length);
    }
}
