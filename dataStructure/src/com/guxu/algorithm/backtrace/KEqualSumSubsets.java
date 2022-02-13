package com.guxu.algorithm.backtrace;

import org.testng.annotations.Test;

/*
698. 划分为k个相等的子集
 */
public class KEqualSumSubsets {
    boolean res = false;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = getSum(nums);
        if (sum % k != 0 || nums.length < k) return false;
        int parSum = sum / k;
        return backtrack(nums, k, parSum, 0,  0);


    }
    private boolean backtrack(int[] nums, int k,  int parSum, int sum, int startIndex) {
//        for (int n : nums) {
//            System.out.print(n + " ");
//        }
        System.out.println();
        if (k == 0) return true;
        if (sum == parSum) return backtrack(nums, k - 1, parSum, 0, 0);
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] <= 0 || sum > parSum || nums[i] > parSum) continue;
            sum += nums[i];
            nums[i] -= 10001;
            if (backtrack(nums, k, parSum, sum, i + 1)) return true;
            nums[i] += 10001;
            sum -= nums[i];
        }
        return false;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        return sum;
    }
    private boolean valid(int[] nums) {
        for (int i: nums) {
            if (i > 0) return false;
        }
        return true;
    }
    @Test
    public void test() {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }
}
