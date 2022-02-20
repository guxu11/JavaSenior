package com.guxu.algorithm.binary.implict;

import org.testng.annotations.Test;

/*
leetcode 69. x 的平方根
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid == x) return mid;
            if ((long)mid * mid < x) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }

    @Test
    public void test() {
        int x = 2;
        System.out.println(mySqrt(x));
    }
}
