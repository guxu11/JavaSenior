package com.guxu.algorithm.twopointers.opposite;

import org.testng.annotations.Test;

import java.util.Arrays;

/*
leetcode 16. 最接近的三数之和
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int leftMax = -1000;
        int rightMin = 1000;
        for (int i = 0; i < n - 1; i++) {
            int lack = target - nums[i];
            int left = i + 1, right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] == lack) return target;
                if (nums[left] + nums[right] > lack){
                    rightMin = Math.min(rightMin, nums[i] + nums[left] + nums[right]);
                    right--;
                    while (right > left && nums[right] == nums[right + 1]) right--;
                }
                else {
                    leftMax = Math.max(leftMax, nums[i] + nums[left] + nums[right]);
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }
        return target - leftMax < rightMin - target ? leftMax : rightMin;
    }

    @Test
    public void test() {
        int[] nums = {0,1,2};
        int target = 0;
        System.out.println(threeSumClosest(nums, target));
    }
}
