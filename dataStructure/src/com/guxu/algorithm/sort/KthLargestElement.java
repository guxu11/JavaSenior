package com.guxu.algorithm.sort;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Random;

/*
leetcode 215 数组中的第k个最大元素
 */
public class KthLargestElement {
    private static Random random;
    // 堆
    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    // 快速选择
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int index = len - k;
        while (true) {
            int partition = findPartition(nums, left, right);
            if (partition == index) return nums[partition];
            else if (partition < index) left = partition + 1;
            else right = partition - 1;
        }

    }

    private void swap(int [] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

    private int findPartition(int[] nums, int left, int right) {
        if (right > left) {
            random = new Random();
            int r = left + random.nextInt(right - left);
            swap(nums, left, r);
        }
        int partition = left;
        int index = partition + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] <= nums[partition]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, partition, index - 1);
        return index - 1;
    }


    @Test
    public void test() {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
        System.out.println(random.nextDouble());
//        int index = findPartition(nums, 0, 5);
//        for (int n: nums) {
//            System.out.println(n);
//        }
//        System.out.println(index);
    }
    @Test
    public void test1() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {

            System.out.println(random.nextInt(10));
        }
    }
}
