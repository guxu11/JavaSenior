package com.guxu.algorithm.sort;

import org.testng.annotations.Test;

/*
leetcode 4. 寻找两个正序数组的中位数
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m + n) / 2;
        if ((m + n) % 2 == 1) {
            return findKthNum(nums1, 0, nums2, 0,  k + 1);
        } else {
            return (findKthNum(nums1, 0, nums2, 0, k) + findKthNum(nums1, 0, nums2, 0, k + 1)) * 1.0 / 2;
        }
    }

    private int findKthNum(int[] nums1, int a, int[] nums2, int b, int k) {
        int m = nums1.length, n = nums2.length;
        if (m - a > n - b) return findKthNum(nums2, b, nums1, a, k);
        if (m == a) return nums2[b + k - 1];
        if (k == 1) return Math.min(nums1[a], nums2[b]);
        int k1, k2;
        if (a + k/2 > m) k1 = m - a;
        else k1 = k / 2;
        k2 = k - k1;
        if (nums1[a + k1 - 1] < nums2[b + k2 - 1]) {
            return findKthNum(nums1, a + k1, nums2, b, k - k1);
        } else {
            return findKthNum(nums1, a, nums2, b + k2, k - k2);
        }

    }
    @Test
    public void test() {
        int[] num1 = {1,3};
        int[] num2 = {2};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

}
