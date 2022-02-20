package com.guxu.algorithm.binary.implict;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.OptionalInt;

/*
leetcode 1891. 割绳子
 */
public class CuttingRibbons {
    public int maxLength(int[] ribbons, int k) {
//        int max = Arrays.stream(ribbons).max().getAsInt();
//        if (max == 0) return 0;
        int max = 0;
        for (int ribbon: ribbons) {
            max = Math.max(max, ribbon);
        }
        int l = 0, r = max;
        while (l < r) {
            int mid = (r - l + 1) / 2 + l;
            int maxCount = maxK(ribbons, mid);
            if (maxCount >= k) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    private int maxK(int[] ribbons, int len) {
        int count = 0;
        for (int ribbon: ribbons) {
            count += ribbon / len;
        }
        return count;
    }

    @Test
    public void test() {
        int[] ribbons = {9,7,5};
        int k = 22;
        System.out.println(maxLength(ribbons, k));
    }
}
