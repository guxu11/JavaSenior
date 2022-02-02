package com.guxu.algorithm.queue;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 362 敲击计数器
 */
public class HitCounter {
    private int count;
    private Queue<Integer> queue;
    public HitCounter() {
        this.count= 0;
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        count++;
        queue.add(timestamp);
    }

    public int getHits(int timestamp) {
        if (queue.size() == 0 ) return 0;
//        int peek = queue.peek();
        while (queue.peek() < timestamp - 299) {
            count--;
            queue.poll();
            if (queue.isEmpty()) break;
        }
        return count;
    }

    @Test
    public void test() {
        for (int i = 1; i <= 3; i++) {
            hit(i);
        };
        hit(300);
        System.out.println(getHits(300));

    }
    @Test
    public void test1() {
        int a = 1;
        if (a++ >= 2) System.out.println(true);
        else System.out.println(false);
        System.out.println(a);
    }
}
