package com.guxu.algorithm.twopointers.samedirction;

import org.testng.annotations.Test;

/*
leetcode 26. 删除有序数组中的重复项
 */
public class RemoveDuplicateNumbersInArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int first = 0, last = 0;
        int p = 0;
        while (last < n) {
            int pNum = nums[first];
            while (last < n && nums[last] == nums[first]) last++;
            first = last;
            nums[p] = pNum;
            p++;
        }
        return p;
    }

    @Test
    public void test() {
        int[] nums = {};
        System.out.println("len: " + removeDuplicates(nums));
        for(int num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
