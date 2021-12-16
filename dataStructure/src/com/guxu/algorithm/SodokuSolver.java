package com.guxu.algorithm;

import org.testng.annotations.Test;
import java.lang.Math;

/*
leetcode 37 解数独
 */

// TODO: 还未完成

public class SodokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }
    private void backtrack(char[][] board, int row, int col) {
        if (row == 8 && col == 8) return;
        if (Character.isDigit(board[row][col])) return;
        for (int i = 1; i <= 9; i++) {
            if (row < 8) {
                board[row][col] = (char) (i + 48);
                backtrack(board, row + 1, col);
                board[row][col] = '.';
            }
            if (col < 8) {
                board[row][col] = (char) (i + 48);
                backtrack(board, row, col + 1);
                board[row][col] = '.';
            }
        }
    }
    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i == row) continue;
            if (board[row][col] == board[i][col]) return false;
        }
        for (int j = 0; j < 9; j++) {
            if (j == col) continue;
            if (board[row][col] == board[row][j]) return false;
        }
        int blockMinRaw = (row / 3) * 3;
        int blockMinCol = (col / 3) * 3;
        for (int i = blockMinRaw; i <= blockMinRaw + 2; i++) {
            for (int j = blockMinCol; j <= blockMinCol + 2; j++) {
                if (i == row && j == col) continue;
                if (board[row][col] == board[i][j]) return false;
            }
        }
        return true;
    }
    @Test
    public void test() {
        int a = 1;
        char c = (char) (a + 48);
        System.out.println(c);

    }
}
