package com.guxu.algorithm;

import org.testng.annotations.Test;
import java.lang.Math;

/*
leetcode 37 解数独
 */


public class SodokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    private boolean backtrack(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') continue;
                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(board, c, i, j)) {
                        board[i][j] = c;
                        if (backtrack(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, char var, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (var == board[i][col]) return false;
        }
        for (int j = 0; j < 9; j++) {
            if (var == board[row][j]) return false;
        }
        int blockMinRaw = (row / 3) * 3;
        int blockMinCol = (col / 3) * 3;
        for (int i = blockMinRaw; i <= blockMinRaw + 2; i++) {
            for (int j = blockMinCol; j <= blockMinCol + 2; j++) {
                if (var == board[i][j]) return false;
            }
        }
        return true;
    }
}
