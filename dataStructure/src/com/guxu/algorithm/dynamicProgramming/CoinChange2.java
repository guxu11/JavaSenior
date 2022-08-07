package com.guxu.algorithm.dynamicProgramming;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
leetcode 518. 零钱兑换 II
 */
public class CoinChange2 {
    // 回溯 超时
    int res = 0;
    public int bfschange(int amount, int[] coins) {
        Arrays.sort(coins);
        Stack<Integer> used = new Stack<>();
        backTrace(amount, coins, used);
        return res;
    }
    private void backTrace(int amount, int[] coins, Stack<Integer> used) {
        if (amount < 0) return;
        if (amount == 0) {
            res++;
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            if (!used.isEmpty() && coins[i] < used.peek()) continue;
            used.push(coins[i]);
            backTrace(amount - coins[i], coins, used);
            used.pop();
        }
    }
    //
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin: coins) {
            for (int i = 1; i <= amount; i++) {
                if (i < coin) continue;
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    @Test
    public void test() {
        int amount = 100;
        int[] coins = {3, 5, 7, 8, 9, 10, 11};
        System.out.println(change(amount, coins));
    }
}
