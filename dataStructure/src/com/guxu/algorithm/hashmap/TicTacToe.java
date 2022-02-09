package com.guxu.algorithm.hashmap;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/*
leetcode 348. 设计井字棋
 */
public class TicTacToe {
    int size;
    Map<String, Integer> rows = new HashMap<>();
    Map<String, Integer> cols = new HashMap<>();
    Map<String, Integer> diagonals = new HashMap<>();
    public TicTacToe(int n) {
        size = n;
    }

    public int move(int row, int col, int player) {
        rows.put("r"+row+"p"+player, rows.getOrDefault("r"+row+"p"+player, 0) + 1);
        cols.put("c"+col+"p"+player, cols.getOrDefault("c"+col+"p"+player, 0) + 1);
        if (row == col) diagonals.put("dlp"+player, diagonals.getOrDefault("dlp"+player, 0) + 1);
        if (row + col == size-1) diagonals.put("drp"+player, diagonals.getOrDefault("drp"+player, 0) + 1);
        return rows.get("r"+row+"p"+player) == size
                || cols.get("c"+col+"p"+player) == size
                || diagonals.getOrDefault("dlp"+player, 0) == size
                || diagonals.getOrDefault("drp"+player, 0) == size
                ? player : 0;
    }


    public static void main(String[] args) {
        TicTacToe t = new TicTacToe(3);
        System.out.println(t.move(2, 0, 1));
        System.out.println(t.move(1, 1, 1));
        System.out.println(t.move(0, 2, 1));

    }
}
