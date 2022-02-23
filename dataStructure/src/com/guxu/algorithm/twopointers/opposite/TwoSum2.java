package com.guxu.algorithm.twopointers.opposite;

import org.testng.annotations.Test;

/*
leetcode 167. 两数之和 II - 输入有序数组
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int lack = target - numbers[left];
            int l = left + 1, r = right;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (numbers[mid] == lack) return new int[]{left + 1, mid + 1};
                if (numbers[mid] < lack) l = mid + 1;
                else r = mid - 1;
            }
            right = r;
            left++;
        }
        return null;
    }

    @Test
    public void test() {
        int[] numbers = {5, 25, 75};
        int target = 100;
        int[] res = twoSum(numbers, target);
        System.out.println(res[0] + " " + res[1]);
    }

}
