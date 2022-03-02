package com.guxu.algorithm.bfs.graph;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 130. 被围绕的区域
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' || visited[i][j]) continue;
                Deque<int[]> queue = new LinkedList<>();
                List<int[]> buffer = new ArrayList<>();
                queue.addLast(new int[]{i,j});
                buffer.add(new int[]{i,j});
                boolean flag = false;
                while (!queue.isEmpty()) {
                    int[] currPos = queue.poll();
                    int x = currPos[0], y = currPos[1];
                    if (board[x][y] == 'O' && (x == 0 || x == m - 1 || y == 0 || y == n - 1)) {
                        flag = true;
                    }
//                    visited[x][y] = true;
                    if (x < m - 1 && board[x+1][y] == 'O' && !visited[x+1][y]) {
                            queue.addLast(new int[]{x + 1, y});
                            buffer.add(new int[]{x + 1, y});
                        visited[x+1][y] = true;
                    }
                    if (x > 0 && board[x-1][y] == 'O' && !visited[x-1][y]) {
                            queue.addLast(new int[]{x - 1, y});
                            buffer.add(new int[]{x - 1, y});
                        visited[x-1][y] = true;
                    }
                    if (y < n - 1 && board[x][y+1] == 'O' && !visited[x][y+1]) {
                            queue.addLast(new int[]{x, y + 1});
                            buffer.add(new int[]{x, y + 1});
                        visited[x][y+1] = true;
                    }
                    if (y > 0 && board[x][y-1] == 'O' && !visited[x][y-1]) {
                            queue.addLast(new int[]{x, y - 1});
                            buffer.add(new int[]{x, y - 1});
                        visited[x][y-1] = true;
                    }
                }
                if (!flag) {
                    for (int[] b : buffer) {
                        board[b[0]][b[1]] = 'X';
                    }
                }
                buffer = new ArrayList<>();
//                for (char[] b: board) {
//                    for (char c: b) {
//                        System.out.print(c + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("=======");
            }
        }

    }

    @Test
    public void test() {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'},
        };
//        char[][] board = {
//                {'O','X','O','O','O','X'},
//                {'O','O','X','X','X','O'},
//                {'X','X','X','X','X','O'},
//                {'O','O','O','O','X','X'},
//                {'X','X','O','O','X','O'},
//                {'O','O','X','X','X','X'}
//        };
        solve(board);
        for (char[] b: board) {
            for (char c: b) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println("=======");
    }
}
