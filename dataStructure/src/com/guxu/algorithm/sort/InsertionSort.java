package com.guxu.algorithm.sort;

import org.testng.annotations.Test;

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 1; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Test
    public void test() {
        int[] a = {3,4,5,1232,-10, -20, 10};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
