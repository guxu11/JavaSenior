package com.guxu.algorithm.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
leetcode 378. 有序矩阵中第 K 小的元素
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < m; i ++) {
            priorityQueue.add(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = priorityQueue.poll();
            if (now[2] != n - 1) {
                priorityQueue.add(new int[]{matrix[now[1]][ now[2] + 1], now[1], now[2]+1});
            }
        }
        return priorityQueue.poll()[0];
    }
}
