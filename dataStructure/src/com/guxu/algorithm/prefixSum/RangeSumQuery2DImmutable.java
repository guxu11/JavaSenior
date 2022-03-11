package com.guxu.algorithm.prefixSum;

import org.testng.annotations.Test;

/*
leetcode 304. 二维区域和检索 - 矩阵不可变
 */

public class RangeSumQuery2DImmutable {

}

class NumMatrix {
    // preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i-1][j-1] + matrix[i][j]
    private int[][] preSum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        preSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = i - 1 < 0 ? 0 : preSum[i - 1][j];
                int up = j - 1 < 0 ? 0 : preSum[i][j - 1];
                int upLeft = i - 1 < 0 || j - 1 < 0 ? 0: preSum[i-1][j-1];
                preSum[i][j] = left + up - upLeft + matrix[i][j];
            }

        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int up = row1 - 1 < 0 ? 0 : preSum[row1 - 1][col2];
        int left = col1 - 1 < 0 ? 0 : preSum[row2][col1 - 1];
        int upLeft = row1 - 1 < 0 || col1 - 1 < 0 ? 0 : preSum[row1-1][col1-1];
        return preSum[row2][col2] - up - left + upLeft;
    }
}
