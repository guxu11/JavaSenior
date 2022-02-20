package com.guxu.algorithm.binary.explicit;

import org.testng.annotations.Test;

/*
leetcode 33. 搜索旋转排序数组
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {5, 1, 3};
        int target = 3;
        System.out.println(search(nums, target));
    }
}
