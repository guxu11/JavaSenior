package com.guxu.algorithm.priorityQueue;

import org.testng.annotations.Test;

import java.util.PriorityQueue;
import java.util.TreeMap;

/*
leetcode 1438. 绝对差不超过限制的最长连续子数组
 */
public class LongestContinuousSubarrayLessThanLimt {
    // TreeMap
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < n) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                treeMap.put(nums[left], treeMap.getOrDefault(nums[left], 0) - 1);
                if (treeMap.get(nums[left]) == 0) treeMap.remove(nums[left]);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }


    @Test
    public void test() {
        int[] nums = {10,1,2,4,7,2};
        int limit = 5;
        System.out.println(longestSubarray(nums, limit));
    }
}
