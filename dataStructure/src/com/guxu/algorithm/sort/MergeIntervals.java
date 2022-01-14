package com.guxu.algorithm.sort;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 56 合并区间
 */
public class MergeIntervals {
    int[][] res;
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        res = new int[intervals.length][2];
        int preL = intervals[0][0], preR = intervals[0][1];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (left <= preR) {
                preR = Math.max(preR, right);
            } else {
                res[index][0] = preL;
                res[index][1] = preR;
                index++;
                preL = left;
                preR = right;
            }

        }
        res[index][0] = preL;
        res[index][1] = preR;
        return Arrays.copyOf(res, index + 1);
    }
    @Test
    public void test() {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
//        int[][] intervals = {{1,4}, {4,5}};
        int[][] res = merge(intervals);
        for (int[] re: res) {
            for (int r: re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
    @Test
    public void test1() {
        int[] nums = {3,21,4,100};
        Arrays.sort(nums);
    }
}
