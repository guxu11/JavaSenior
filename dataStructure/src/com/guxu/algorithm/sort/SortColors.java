package com.guxu.algorithm.sort;

import org.testng.annotations.Test;

/*
leetcode 75 颜色分类
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums.length < 2) return;
        // all in [0, p0) == 0;
        // all in [p0, i) == 1;
        // all in (p2, len - 1] == 2;
        int p0 = 0, p2 = nums.length - 1, i = 0;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                i++;
            }
            else if (nums[i] == 1) {
                i++;
            }
            else{
                swap(nums, i, p2);
                p2--;
            }
        }
    }
    private void swap(int[] nums, int left, int right) {
        int swap = nums[left];
        nums[left] = nums[right];
        nums[right] = swap;
    }

    @Test
    public void test() {
        int[] nums = {1,0,2};
        sortColors(nums);
        for (int num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
