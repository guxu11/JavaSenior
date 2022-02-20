package com.guxu.algorithm.binary.explicit;

import org.testng.annotations.Test;

/*
leetcode 1095. 山脉数组中查找目标值
 */
public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peek = findPeek(mountainArr);
        if ((target < mountainArr.get(0) && target < mountainArr.get(n - 1)) || target > mountainArr.get(peek)) {
            return -1;
        }
        int left = 0, right = peek;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midNum = mountainArr.get(mid);
            if (midNum == target) return mid;
            if (midNum < target) left = mid + 1;
            else right = mid - 1;
        }
        left = peek + 1;
        right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midNum = mountainArr.get(mid);
            if (midNum == target) return mid;
            if (midNum < target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public int findPeek(MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid < n - 1 && mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return mountainArr.get(left) > mountainArr.get(right) ? left : right;
    }
    @Test
    public void test() {
        int[] array = {3,5,3,2,0};
        int target = 0;
        MountainArray mountainArray = new MountainArray(array);
        System.out.println(findPeek(mountainArray));
        System.out.println(findInMountainArray(target, mountainArray));
    }
}

class MountainArray {
    private int[] array;
    public MountainArray(int[] arr) {
        array = arr;
    }
    public int get(int index) {
        if (index >= array.length) throw new ArrayIndexOutOfBoundsException("index " + index + " out of bound of size " + array.length);
        return array[index];
    }
    public int length() {
        return array.length;
    }
}