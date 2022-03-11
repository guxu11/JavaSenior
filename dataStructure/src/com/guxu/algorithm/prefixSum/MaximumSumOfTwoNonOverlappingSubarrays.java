package com.guxu.algorithm.prefixSum;

import org.testng.annotations.Test;

/*
leetcode 1031. 两个非重叠子数组的最大和
 */
public class MaximumSumOfTwoNonOverlappingSubarrays {
    // O(n^2)
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] preSum = makePreSum(nums, 0, n - 1);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= n - firstLen; i++) {
            int firstSum = preSum[i + firstLen] - preSum[i];
            int sum = firstSum + Math.max(maxSum(nums, secondLen, 0,  i - 1), maxSum(nums, secondLen, i + firstLen, n - 1));
            System.out.print(sum + " ");
            res = Math.max(res, sum);
        }
        return res;
    }
    
    private int maxSum(int[] nums, int k, int left, int right) {
        int n = right - left + 1;
        if (n < k || left < 0 || right >= nums.length) return 0;
        int [] preSum = makePreSum(nums, left, right);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int extra = preSum[i + k] - preSum[i];
            res = Math.max(res, extra);
        }
        return res;
    }

    private int[] makePreSum(int[] nums, int left, int right) {
        int n = right - left + 1;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[left + i - 1];
        }
        return preSum;
    }

    @Test
    public void test() {
        int[] nums = {8,20,6,2,20,17,6,3,20,8,12};
        int L = 5, M = 4;
        System.out.println(maxSumTwoNoOverlap(nums, L, M));
    }
}
