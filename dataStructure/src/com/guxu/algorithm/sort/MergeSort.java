package com.guxu.algorithm.sort;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;

public class MergeSort {
    public int[] mergeSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while(i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }

    @Test
    public void test() {
        int[] left = {1,3,7,100};
        int[] right = {2,4,6,10};
        int[] src = {2,5,1,4,100,0,3};
        int[] res = mergeSort(src);
        for (int r: res) {
            System.out.print(r + " ");
        }
        System.out.println();

    }
    @Test
    public void test1() {
        int a = 3;
        System.out.println(Math.floor(a / 2));
    }
}
