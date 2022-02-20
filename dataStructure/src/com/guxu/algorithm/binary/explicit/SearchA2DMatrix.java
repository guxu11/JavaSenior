package com.guxu.algorithm.binary.explicit;

import org.testng.annotations.Test;

/*
leetcode 74. 搜索二维矩阵
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m - 1;
        int left = 0, right = n - 1;
        int row = -1;
        while (low < high) {
            int mid = low + (high - low) / 2;
//            System.out.println(mid);
            if (matrix[mid][right] == target) {
                return true;
            }
            else if (matrix[mid][left] > target) high = mid - 1;
            else if (matrix[mid][left] < target) high = mid;
        }
        System.out.println("low = " + low + " high = " + high);
        row = low + 1;
//        if (row >= m) return false;
//        System.out.println("row is " + row);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    @Test
    public void test() {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] matrix = {{1}};
        int target = 2;
        System.out.println(searchMatrix(matrix, target));
    }
}
