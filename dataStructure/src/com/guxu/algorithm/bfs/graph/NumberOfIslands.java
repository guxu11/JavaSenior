package com.guxu.algorithm.bfs.graph;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

/*
leetcode 200. 岛屿数量
 */
public class NumberOfIslands {
    // BFS
    public int numIslandsBFS(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                Deque<int[]> deque = new LinkedList<>();
                deque.addLast(new int[]{i,j});
                while (!deque.isEmpty()) {
                    int[] index = deque.poll();
                    grid[index[0]][ index[1]] = '0';
                    if (index[0] + 1 < m && grid[index[0] + 1][index[1]] == '1') {
                        deque.addLast(new int[]{index[0] + 1, index[1]});
                        grid[index[0] + 1][ index[1]] = '0';
                    }
                    if (index[1] + 1 < n && grid[index[0]][index[1] + 1] == '1') {
                        deque.addLast(new int[]{index[0], index[1] + 1});
                        grid[index[0]][ index[1] + 1] = '0';
                    }
                    if (index[0] - 1 >= 0 && grid[index[0] - 1][index[1]] == '1') {
                        deque.addLast(new int[]{index[0] - 1, index[1]});
                        grid[index[0] - 1][ index[1]] = '0';
                    }
                    if (index[1] - 1 >= 0 && grid[index[0]][index[1] - 1] == '1') {
                        deque.addLast(new int[]{index[0], index[1] - 1});
                        grid[index[0]][ index[1] - 1] = '0';
                    }
                }
                res++;
            }
        }
        return res;
    }
    // DFS
    public int numIslandsDFS(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') res++;
                else continue;
                infect(grid, i, j);
            }
        }
        return res;
    }

    private void infect(char[][] grid, int row, int col) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] == '0') return;
        grid[row][col] = '0';
        infect(grid, row - 1, col);
        infect(grid, row + 1, col);
        infect(grid, row, col - 1);
        infect(grid, row, col + 1);
    }

    @Test
    public void test() {
//        char[][] grid = new char[][] {
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}
//        };
        char[][] grid = new char[][] {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        System.out.println(numIslandsDFS(grid));

    }
}
