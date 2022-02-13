package com.guxu.algorithm.priorityQueue;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
leetcode 264. 丑数 II
 */
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] nums = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        seen.add(1L);
        priorityQueue.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr =  priorityQueue.poll();
            ugly = (int) curr;
            for (int num: nums) {
                if (seen.add(num * curr)) {
                    priorityQueue.add(num * curr);
                }
            }
        }
        return ugly;
    }

    public int nthUglyNumberDp(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i < n + 1; i++) {
            int num2 = 2 * dp[p2], num3 = 3 * dp[p3], num5 = 5 * dp[p5];
            dp[i] = Math.min(Math.min(num3, num5), num2);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];

    }
    @Test
    public void test() {
        System.out.println(nthUglyNumberDp(10));
    }
}
