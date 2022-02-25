package com.guxu.algorithm.twopointers.samedirction;

import org.testng.annotations.Test;

/*
leetcode 283. 移动零
 */
public class MoveZreos {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int z = 0, r = 0;
        while (r < n) {
            while (z < n && nums[z] != 0) z++;
            if (z < n && z > r) swap(nums, z, r);
            r++;
        }
    }

    private void swap(int[] nums, int l1, int l2) {
        int temp = nums[l1];
        nums[l1] = nums[l2];
        nums[l2] = temp;
    }

    @Test
    public void test() {
        int[] nums = {1,0};
        moveZeroes(nums);
        for(int num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
