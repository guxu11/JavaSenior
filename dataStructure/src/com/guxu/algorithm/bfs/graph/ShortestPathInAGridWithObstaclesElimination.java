package com.guxu.algorithm.bfs.graph;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

/*
leetcode 1293. 网格中的最短路径
 */
public class ShortestPathInAGridWithObstaclesElimination {
    private int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1)return 0;
        if (k >= m + n - 3) return m + n - 2;
        Deque<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{0,0,k});
        boolean[][][] visited = new boolean[m][n][k+1];
        visited[0][0][k] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currPos = queue.poll();
                int x = currPos[0], y = currPos[1], kLeft = currPos[2];
                for (int[] direction: directions) {
                    int newX = x + direction[0], newY = y + direction[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (kLeft > 0 && !visited[newX][newY][kLeft-1] && grid[newX][newY] == 1) {
                            visited[newX][newY][kLeft-1] = true;
                            queue.addLast(new int[]{newX, newY, kLeft-1});
                        } else if (grid[newX][newY] == 0 && !visited[newX][newY][kLeft]) {
                            if(newX == m - 1 && newY == n - 1) return ++res;
                            visited[newX][newY][kLeft] = true;
                            queue.addLast((new int[]{newX, newY, kLeft}));
                        }
                    }
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
                {0,0,0},
                {0,1,1},
                {0,0,0}
        };
        int k = 1;
        System.out.println(shortestPath(grid, k));
    }
}
