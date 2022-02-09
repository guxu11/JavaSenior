package com.guxu.algorithm.hashmap;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 128 最长连续序列
 */
public class LongestConsecutive {
    Set<Integer> set = new HashSet<>();
    public int longestConsecutive(int[] nums) {
        for (int num : nums) set.add(num);
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currMax = 1;
                while (set.contains(currNum + 1)) {
                    currMax++;
                    currNum++;
                }
                res = Math.max(currMax, res);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1,-8,7,-2,-4,-4,6,3,-4,0,-7,-1,5,1,-9,-3};
        System.out.println(longestConsecutive(nums));
//        System.out.println(map.keySet());
    }
}
