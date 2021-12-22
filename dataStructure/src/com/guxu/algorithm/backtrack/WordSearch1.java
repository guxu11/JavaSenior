package com.guxu.algorithm.backtrack;

/*
leetcode 79单词搜索
 */

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WordSearch1 {
    private boolean result;
    public boolean exist(char[][] board, String word) {
        List<Character> track = new ArrayList<>();
        boolean used[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    backtrack(board, word, 1, i, j, used);
                    if (result) return result;
                    used[i][j] = false;
                }
            }
        }
        return result;
    }

    private void backtrack(char[][] board, String word, int index, int currRow, int currCol, boolean[][] used) {
        if (index == word.length()) result = true;
        if (!result && currRow < board.length - 1 && !used[currRow + 1][currCol] && word.charAt(index) == board[currRow + 1][currCol]) {
            used[currRow + 1][currCol] = true;
            backtrack(board, word, index + 1, currRow + 1, currCol, used);
            used[currRow + 1][currCol] = false;
        }
        if (!result && currRow >= 1 && !used[currRow - 1][currCol] && word.charAt(index) == board[currRow - 1][currCol]) {
            used[currRow - 1][currCol] = true;
            backtrack(board, word, index + 1, currRow - 1, currCol, used);
            used[currRow - 1][currCol] = false;
        }
        if (!result && currCol < board[0].length - 1 && !used[currRow][currCol + 1] && word.charAt(index) == board[currRow][currCol + 1]) {
            used[currRow][currCol + 1] = true;
            backtrack(board, word, index + 1, currRow, currCol + 1, used);
            used[currRow][currCol + 1] = false;
        }
        if (!result && currCol >= 1 && !used[currRow][currCol - 1] && word.charAt(index) == board[currRow][currCol - 1]) {
            used[currRow][currCol - 1] = true;
            backtrack(board, word, index + 1, currRow, currCol - 1, used);
            used[currRow][currCol - 1] = false;
        }

    }


    @Test
        public void test() {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            String word = "AB";
            System.out.println(exist(board, word));
        }

        @Test
        public void test2() {
            char a = 'A';
            System.out.println((char)(a + 128));
        }
    }


