package com.guxu.algorithm.binary.explicit;

import org.testng.annotations.Test;

/*
leetcode 240. 搜索二维矩阵 II
 */
public class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n){
//            System.out.println("i = " + i + " j = " + j);
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) i--;
            else j++;
        }
        return false;
    }
    @Test
    public void test() {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }
}
