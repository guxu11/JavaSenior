package com.guxu.algorithm.backtrack;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/*
leetocde 526. 优美的排列
 */
public class beautifulArrangement {
    int res;
    public int countArrangement(int n) {
        if (n == 0) return 0;
//        List<Integer> track = new ArrayList<>();
        boolean[] used = new boolean[n];
        backtrack(n, 0,  used);
        return res;

    }

    private void backtrack(int n, int len,  boolean[] used) {
        if (len == n) {
            res++;
//            backtrack(n, new ArrayList<Integer>(), new boolean[n]);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            if ((i + 1) % (len + 1) != 0 && (len + 1) % (i + 1) != 0) continue;
            len++;
            used[i] = true;
            backtrack(n, len, used);
            used[i] = false;
            len--;
        }
    }

    @Test
    public void test() {
        countArrangement(1);
        System.out.println(res);
    }
}
