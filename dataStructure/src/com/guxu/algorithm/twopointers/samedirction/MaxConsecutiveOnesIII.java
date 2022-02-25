package com.guxu.algorithm.twopointers.samedirction;

import org.testng.annotations.Test;

/*
leetcode 1004. 最大连续1的个数 III
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int count = 0;
        int res = 0;
        while (right < n) {
            if (nums[right] == 0) {
                count++;
            }
            if (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            } else {
                res = Math.max(right - left + 1, res);
            }
            right++;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }
}
