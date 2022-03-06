package com.guxu.algorithm.bfs.graph;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

/*
leetcode 1091. 二进制矩阵中的最短路径
 */
public class ShortestPathInBinaryMatrix {
    int[][] directions = {
            {-1, 0},
            {-1, -1},
            {0, -1},
            {-1, 1},
            {0, 1},
            {1, 1},
            {1, 0},
            {1, -1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
//        if (n == 1) return 1;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Deque<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{0,0});
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currPos = queue.poll();
                int x = currPos[0], y = currPos[1];
                if (grid[x][y] == 1) continue;
                for (int[] direction: directions) {
                    int newX = x + direction[0], newY = y + direction[1];
                    if (newX == n - 1 && newY == n - 1) return ++res;
                    if (newX < 0 || newX > n - 1 || newY < 0 || newY > n - 1 || grid[newX][newY] == 1) continue;
                    queue.addLast(new int[]{newX, newY});
                    grid[newX][newY] = 1;
                }
            }
            res++;
        }
        return -1;

    }

    @Test
    public void test() {
        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
