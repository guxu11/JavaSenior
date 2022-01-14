package com.guxu.algorithm.sort;

import org.testng.annotations.Test;

/*
leetcode 27 移除元素
 */
public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while(left <= right) {
            if (nums[left] == val) {
                if (nums[right] == val) {
                    right--;
                } else {
                    nums[left] = nums[right];
                    nums[right] = val;
                    left++;
                    right--;
                }
                len--;
            }else {
                left++;
            }
        }
        return len;
    }

    @Test
    public void test() {
        int[] nums = {1};
        int len = removeElement(nums, 1);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
