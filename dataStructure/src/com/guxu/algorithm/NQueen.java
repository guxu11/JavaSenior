package com.guxu.algorithm;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class NQueen {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> track = new ArrayList<>();
        char[][] chars = new char[n][n];
        for (char[] c: chars) {
            Arrays.fill(c, '.');
        }
        backtrack(chars, 0);
        return res;
    }

    private void backtrack(char[][] chars, int row) {
        if (row == chars.length) {
            List<String> currRow = new ArrayList<>();
            for (char[] c: chars) {
                currRow.add(new String(c));
            }
            res.add(new ArrayList<>(currRow));
            return;
        }
        int n = chars[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(chars, row, col)) {
                continue;
            }
            chars[row][col] = 'Q';
            backtrack(chars, row + 1);
            chars[row][col] = '.';
        }
    }
    private boolean isValid(char[][] chars, int row, int col) {
        int n = chars.length;
        for (int i = row - 1; i >= 0; i--) {
            if (chars[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chars[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') return false;
        }
        return true;
    }
    @Test
    public void testRes() {
        int n = 14;
        List<List<String>> res = solveNQueens(n);
        System.out.println(res.size());
    }

    @Test
    public void test() {

        char[][] cs = new char[5][5];
        for (char[] c: cs) {
            Arrays.fill(c, '.');
        }
        String[] ss = new String[5];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = new String(cs[i]);
        }
        for (String s: ss) {
            System.out.println(s);
        }
    }
}
