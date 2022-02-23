package com.guxu.algorithm.twopointers.opposite;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
leetcode 15. 三数之和
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] > target) right--;
                else if (nums[left] + nums[right] < target) left++;
                else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) left++;
                    while (right >= 1 && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
    @Test
    public void test() {
        int[] nums = {-2,0,0,2};
        System.out.println(threeSum(nums));
    }
}
