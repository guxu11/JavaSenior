package com.guxu.algorithm.binary.implict;

import org.testng.annotations.Test;


/*
leetcode 1300. 转变数组后最接近目标值的数组和
 */
public class SumOfMutatedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {
        int max = 0;
        for (int num: arr) {
            max = Math.max(max, num);
        }
        int l = 0, r = max;
        int low, high;
        while (l < r) {
            int mid = (r - l + 1) / 2 + l;
            int sum = reconstructSum(arr, mid);
            if (sum == target) return mid;
            if (sum < target) l = mid;
            else r = mid - 1;
        }
        low = l;
        l = 0;
        r = max;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            int sum = reconstructSum(arr, mid);
            if (sum == target) return mid;
            if (sum < target) l = mid + 1;
            else r = mid;
        }
        high = r;
        return Math.abs(reconstructSum(arr, low) - target) <= Math.abs(reconstructSum(arr, high) - target) ? low: high;
    }

    private int reconstructSum(int[] arr, int res) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = arr[i] > res ? sum + res: sum + arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfMutatedArrayClosestToTarget sum = new SumOfMutatedArrayClosestToTarget();

    }
}
