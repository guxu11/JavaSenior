package com.guxu.algorithm.priorityQueue;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/*
leetcode 973. 最接近原点的 K 个点
TOP K 问题
 */
public class KClosestPoints {
    // 用堆
    PriorityQueue<int[]> priorityQueue;
    public int[][] kClosest(int[][] points, int k) {
        priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -(o1[0] * o1[0] + o1[1] * o1[1] - (o2[0] * o2[0] + o2[1] * o2[1]));
            }
        });

        for (int[] point: points) {
            priorityQueue.add(point);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        return priorityQueue.toArray(new int[][]{});
    }

    // 快速搜索
    public int[][] quickSearch (int[][] points, int k) {
        int left = 0, right  = points.length - 1;
        while (true) {
            int partition = findPartition(points, left, right);
            if (partition == k - 1) return Arrays.copyOfRange(points, 0, k);
            else if (partition < k - 1) left = partition + 1;
            else right = partition - 1;
//            System.out.println(partition);
        }
    }

    private void swap (int i, int j, int[][] arr) {
        int[] swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    private int findPartition(int[][] points, int left, int right) {
        if (right > left) {
            Random random = new Random();
            int r = left + random.nextInt(right - left + 1);
            swap(left, r, points);
        }
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (gt(points[left], points[i])) {
                swap(i, index, points);
                index++;
            }
        }
        swap(index - 1, left, points);
//        System.out.println(index - 1);
        return index - 1;
    }

    private boolean gt(int[] a, int[] b) {
        return (a[0] * a[0] + a[1] * a[1]) > (b[0] * b[0] + b[1] * b[1]);
    }

    @Test
    public void test() {
        int[][] points = {{0,1}, {1,0}};
        int k = 2;
        int[][] res = quickSearch(points, k);
        for(int[] a: res) {
            for(int b: a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
