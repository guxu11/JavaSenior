package com.guxu.algorithm.backtrace;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 1376 通知所有员工所需的时间
 */
public class InformAllEmployees {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int max = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for (int i = 0; i < n; i++) {
            if (i == headID) continue;
            if (!map.containsKey(manager[manager[i]])) {
                map.put(manager[manager[i]], new HashSet<>());
            }
            map.get(manager[manager[i]]).add(manager[i]);
        }
        dfs(headID, informTime[headID], informTime);
        return max;
    }
    private void dfs(int idx, int sum, int[] informTime) {
        if (!map.containsKey(idx)) {
            max = Math.max(sum, max);
            return ;
        }
        Set<Integer> list = map.get(idx);
        for (int i: list) {
            dfs(i, sum + informTime[i], informTime);
        }
    }

    @Test
    public void test() {
        numOfMinutes(15, 0, new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6}, new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0});
//        numOfMinutes(4, 2, new int[]{3,3,-1,2}, new int[]{0,0,162,914});
        System.out.println(max);
    }
}
