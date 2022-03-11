package com.guxu.algorithm.prefixSum;

import org.testng.annotations.Test;

/*
leetcode 1423
 */
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] preSum = new int[n+1];
        preSum[0] = 0;
        for (int i = 1; i < n+1; i++) {
            preSum[i] = preSum[i - 1] + cardPoints[i - 1];
        }
        int sumAll = preSum[n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            int extra = preSum[n + i - k] - preSum[i];
            res = Math.max(res, sumAll - extra);
        }
        return res;
    }
    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(nums, k));
    }
}
