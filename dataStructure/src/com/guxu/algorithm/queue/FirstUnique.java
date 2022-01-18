package com.guxu.algorithm.queue;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 1429 第一个唯一数字
 */
public class FirstUnique {
    private Queue<Integer> queue = new LinkedList<>();
    private Map<Integer, Integer> map = new HashMap<>();
    public FirstUnique(){};
    public FirstUnique(int[] nums) {
        for (int num: nums) {
            queue.add(num);
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty()) {
            int head = queue.peek();
            if (map.get(head) == 1) return head;
            queue.poll();
        }
        return -1;
    }

    public void add(int value) {
        queue.add(value);
        if (!map.containsKey(value)) map.put(value, 1);
        else map.put(value, map.get(value) + 1);
    }

    @Test
    public void test() {
        int[] nums = {3,4,5};
        map.put(1,2);
        System.out.println(map.get(0));
    }
}
