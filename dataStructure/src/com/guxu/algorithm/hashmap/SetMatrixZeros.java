package com.guxu.algorithm.hashmap;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/*
leetcode 73 矩阵置零
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int row: rows) {
            for (int col = 0; col < matrix[0].length; col++) matrix[row][col] = 0;
        }
        for (int col: cols) {
            for (int row = 0; row < matrix.length; row++) matrix[row][col] = 0;
        }
    }

    @Test
    public void test() {

    }
}
