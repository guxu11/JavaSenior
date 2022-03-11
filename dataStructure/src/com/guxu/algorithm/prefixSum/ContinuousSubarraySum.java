package com.guxu.algorithm.prefixSum;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
leetcode 523. 连续的子数组和
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n+1];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            if (preSum[i] % k == 0) return true;
        }
        for (int i = 2; i <= n; i++) {
            set.add(preSum[i - 2] % k);
            if (set.contains(preSum[i] % k)) return true;
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(0 % 2);
    }
}
