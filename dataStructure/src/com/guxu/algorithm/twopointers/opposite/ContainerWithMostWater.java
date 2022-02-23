package com.guxu.algorithm.twopointers.opposite;

import org.testng.annotations.Test;

/*
leetcode 11. 盛最多水的容器
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(getArea(height, l, r), res);
            if (height[l] >= height[r]) r--;
            else l++;
        }
        return res;
    }

    private int getArea(int[] nums, int l, int r) {
        return Math.min(nums[l], nums[r]) * (r - l);
    }

    @Test
    public void test() {
        int[] height = {1,1};
        System.out.println(maxArea(height));
    }
}
