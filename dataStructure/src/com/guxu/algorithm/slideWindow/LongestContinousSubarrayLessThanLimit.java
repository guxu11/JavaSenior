package com.guxu.algorithm.slideWindow;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

/*
leetcode 1438. 绝对差不超过限制的最长连续子数组
 */
public class LongestContinousSubarrayLessThanLimit {
    // 单调队列
    // 两个单调队列，一个递增，一个递减
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        int res = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            while (!minDeque.isEmpty() && nums[right] < nums[minDeque.peekLast()]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);
            while (!maxDeque.isEmpty() && nums[right] > nums[maxDeque.peekLast()]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            while (!minDeque.isEmpty() && left > minDeque.peekFirst()) minDeque.pollFirst();
            while (!maxDeque.isEmpty() && left > maxDeque.peekFirst()) maxDeque.pollFirst();
            int gap = nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()];
//            System.out.println(gap);
            if (gap <= limit) {
                res = Math.max(res, right - left + 1);
                right++;
            }
            else left++;
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
