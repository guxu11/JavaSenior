package com.guxu.algorithm.binary.implict;

import org.testng.annotations.Test;

/*
leetcode 540. 有序数组中的单一元素
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        if (n == 0 || nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 2;
                } else {
                    if (nums[mid] == nums[mid - 1]) right = mid - 2;
                    else return nums[mid];
                }
            } else {
                if (nums[mid] == nums[mid - 1]) left = mid + 1;
                else {
                    if (nums[mid] == nums[mid + 1]) right = mid - 1;
                    else return nums[mid];
                }
            }
        }
        return nums[right];
    }

    @Test
    public void test() {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
}
