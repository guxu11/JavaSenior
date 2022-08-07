package com.guxu.algorithm.sort;

import org.testng.annotations.Test;

public class SortPractice {
    public int[] sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = findPartition(nums, left, right);
            sort(nums, left, pivot - 1);
            sort(nums, pivot + 1, right);
        }
    }

    private int findPartition(int[] nums, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=  nums[j];
        nums[j] = temp;
    }


    @Test
    public void test() {
        int[] nums = {3,6,1,19,0,29,4};
        int[] res = sort(nums);
        for (int e: res) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
