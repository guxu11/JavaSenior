package com.guxu.algorithm.binary.implict;

import org.testng.annotations.Test;

/*
leetcode 1060. 有序数组中的缺失元素
 */
public class MissingElementInSortedArray {
    // 线性查找 O(n)
    public int missingElement2(int[] nums, int k) {
        int n = nums.length, first = nums[0];
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) return nums[i] + k - sum;
            int preSum = sum;
            System.out.println("preSum " + preSum);
            sum += nums[i + 1] - nums[i] - 1;
            System.out.println("Sum " + sum);
            System.out.println(i);
            if (sum == k) return nums[i + 1] - 1;
            else if (sum > k) {
                int interval = k - preSum;
                return nums[i] + interval;
            }
        }
        return res;
    }

    // 二分 (O(logN))
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int total = missing(nums, n - 1);
        if (k > total) {
            return nums[n - 1] + k - total;
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            int midMissing = missing(nums, mid);
            if (midMissing < k) l = mid + 1;
            else r = mid;
        }
        return nums[l - 1] + k - missing(nums, l - 1);
    }

    private int missing(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
    @Test
    public void test() {
        int[] nums = {4,7,9,10};
        int k = 4;
        System.out.println(missingElement(nums, k));
    }
}
