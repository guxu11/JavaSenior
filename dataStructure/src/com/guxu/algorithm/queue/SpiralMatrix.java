package com.guxu.algorithm.queue;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        while (true) {
            for (int i = l; i <= r; i++) res.add(matrix[u][i]);
            if (++u > d) break;
            for (int i = u; i <= d; i++) res.add(matrix[i][r]);
            if (--r < l) break;
            for (int i = r; i >= l; i--) res.add(matrix[d][i]);
            if (--d < u) break;
            for (int i = d; i >= u; i--) res.add(matrix[i][l]);
            if (++l > r) break;
        }

        return res;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(spiralOrder(matrix));
    }
}
