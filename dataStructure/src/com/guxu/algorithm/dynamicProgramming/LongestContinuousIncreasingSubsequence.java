package com.guxu.algorithm.dynamicProgramming;

/*
leetcode 674. 最长连续递增序列
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int res = 1;
        for (int i = 1; i < n; i++) {
            int m = res;
            if (nums[i] > nums[i - 1]) {
                m++;
                res = Math.max(m, res);
            } else m = 1;
        }
        return res;
    }
}
