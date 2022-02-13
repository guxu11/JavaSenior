package com.guxu.algorithm.priorityQueue;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
leetcode 347. 前 K 个高频元素
 */
public class TopKLargestElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int key: map.keySet()) {
            priorityQueue.add(key);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        int[] res = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            res[i] = priorityQueue.poll();
            i++;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        for (int r: res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
