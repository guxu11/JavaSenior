package com.guxu.algorithm.binary.explicit;

import org.testng.annotations.Test;

/*
leetcode 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    private int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if (nums[left] != target) return -1;
        else return left;
    }

    private int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        if (nums[right] != target) return -1;
        else return right;
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    @Test
    public void test() {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        for (int r: res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
