package com.guxu.algorithm.memoSearch;

import org.testng.annotations.Test;

import java.nio.channels.InterruptedByTimeoutException;
import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
leetcode 329 矩阵中的最长递增路径
 */
public class LongestIncreasingPath {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        int res = Integer.MIN_VALUE;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, backtrace(matrix, i, j, memo));
            }
        }
        return res;
    }

    private int backtrace (int[][] matrix, int row, int col, int[][] memo) {
        if (row == matrix.length || row < 0 || col == matrix[0].length || col < 0) return 1;
        if (memo[row][col] != 0) return memo[row][col];
        int res = 1;
        for (int[] d: directions) {
            if (row + d[0] >= 0 && row + d[0] < matrix.length && col + d[1] >= 0 && col + d[1] < matrix[0].length && matrix[row][col] < matrix[row + d[0]][col + d[1]]) {
                res = Math.max( 1 + backtrace(matrix, row + d[0], col + d[1], memo), res);
            }
        }
        memo[row][col] = res;
        return res;
    }

    @Test
    public void test() {
//        int[][] matrix = {{3,4,5}, {3,2,6}, {2,2,1}};
        int[][] matrix = {{1}};
        int res = longestIncreasingPath(matrix);
        System.out.println(res);
    }
    @Test
    public void test1() {
        Map<Integer, String> map = new Hashtable<>();
        Map<Integer, String> map1 = new HashMap<>();
        map.put(1, "gx");
        System.out.println(map);
    }

}
