package com.guxu.algorithm.bfs.graph;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

/*
Leetcode 490 迷宫
 */
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m+2][n+2];
        int[][] mazeExpand = new int[m+2][n+2];
        for (int i = 0; i < m+2; i++) {
            mazeExpand[i][0] = 1;
            mazeExpand[i][n+1] = 1;
        }
        for (int j = 0; j < n+2; j++) {
            mazeExpand[0][j] = 1;
            mazeExpand[m+1][j] = 1;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                mazeExpand[i][j] = maze[i-1][j-1];
            }
        }
        Deque<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{start[0]+1, start[1]+1});
        while (!queue.isEmpty()) {
            int[] currPos = queue.poll();
            int x = currPos[0], y = currPos[1];
            if (x == destination[0] + 1 && y == destination[1] + 1) return true;
            if (visited[x][y]) continue;
            visited[x][y] = true;
            int pX = x, pY = y;
            while (mazeExpand[pX][pY] != 1) --pX;
            if (!visited[pX+1][pY]) queue.addLast(new int[]{pX+1,pY});
            pX = x; pY = y;
            while (mazeExpand[pX][pY] != 1) ++pX;
            if (!visited[pX-1][pY])queue.addLast(new int[]{pX-1, pY});
            pX = x; pY = y;
            while (mazeExpand[pX][pY] != 1) --pY;
            if (!visited[pX][pY+1])queue.addLast(new int[]{pX, pY+1});
            pX = x; pY = y;
            while (mazeExpand[pX][pY] != 1) ++pY;
            if(!visited[pX][pY-1])queue.addLast(new int[]{pX, pY-1});
        }
        return false;
    }

    @Test
    public void test() {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}};
        int[] start = {0,4};
        int[] des = {4,4};
        System.out.println(hasPath(maze, start, des));
    }
}
