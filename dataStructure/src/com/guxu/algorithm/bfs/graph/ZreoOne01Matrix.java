package com.guxu.algorithm.bfs.graph;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
leetcode 542. 01 矩阵
多源bfs
 */
public class ZreoOne01Matrix {
    private int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) queue.addLast(new int[]{i,j});
                else mat[i][j] = -1;
            }
        }
        while (!queue.isEmpty()) {
            int[] currPos = queue.poll();
            int x = currPos[0], y = currPos[1];
            for (int i = 0; i < directions.length; i++) {
                int newX = x + directions[i][0], newY = y + directions[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && mat[newX][newY] == -1) {
                    mat[newX][newY] = mat[x][y] + 1;
                    queue.addLast(new int[]{newX, newY});
                }
            }
        }
        return mat;

    }
    private int findDistance(int[][] mat, int x, int y) {
        if (mat[x][y] == 0) return 0;
        int m = mat.length, n = mat[0].length;
        int res = 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{x, y});
        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currPos = queue.poll();
                int currX = currPos[0], currY = currPos[1];
                for (int[] direction: directions) {
                    int newX = currX + direction[0], newY = currY + direction[1];
                    if (newX < 0 || newX > m - 1 || newY < 0 || newY > n - 1 || visited[newX][newY]) continue;
                    if (mat[newX][newY] == 0) return ++res;
                    visited[newX][newY] = true;
                    queue.addLast(new int[]{newX, newY});
                }
            }
            res++;
        }
        return -1;
    }

    @Test
    public void test() {
        int[][] mat = {
                {1},
//                {0,1,0},
//                {0,0,0}
        };
        int[][] res = updateMatrix(mat);
        for (int[] r: res) {
            for(int e: r) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
