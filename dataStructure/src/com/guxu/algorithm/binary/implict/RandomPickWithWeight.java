package com.guxu.algorithm.binary.implict;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
leetcode 528. 按权重随机选择
 */
public class RandomPickWithWeight {
    public static void main(String[] args) {
        Solution s = new Solution(new int[]{1,2,3});
        int[] intervals = s.intervals;
        for (int num: intervals) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(s.pickIndex());
    }
}

class Solution {
    Random random = new Random();
    int[] intervals;
    public Solution(int[] w) {
        intervals = new int[w.length];
        int sum = 0;
        for (int i = 0; i <w.length ; i++) {
            sum += w[i];
            intervals[i] = sum;
        }
    }

    public int pickIndex() {
        int total = intervals[intervals.length - 1];
        int target = 1 + random.nextInt(total);
         System.out.println("target: " + target);
        int l = 0, r = intervals.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target == intervals[mid]) return mid;
            if (target < intervals[mid]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}

