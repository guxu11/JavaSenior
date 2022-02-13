package com.guxu.algorithm.priorityQueue;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
leetcode 295. 数据流的中位数
 */
public class MedianFinder {
    PriorityQueue<Integer> l;
    PriorityQueue<Integer> r;
    public MedianFinder() {
        r = new PriorityQueue<>();
        l = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        int sizeL = l.size(), sizeR = r.size();
        if (sizeL == sizeR) {
            if (sizeR == 0 || r.peek() >= num) l.offer(num);
            else {
                l.offer(r.poll());
                r.offer(num);
            }
        } else {
            if (num >= l.peek()) r.offer(num);
            else {
                r.offer(l.poll());
                l.offer(num);
            }
        }
    }

    public double findMedian() {
        int sizeL = l.size(), sizeR = r.size();
        if (sizeL == sizeR) {
            if (sizeL == 0) return 0;
            else return (l.peek() + r.peek()) / 2.0;
        } else {
            return l.peek() / 1.0;
        }
    }

    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.r.offer(1);
        medianFinder.r.offer(2);
        System.out.println(medianFinder.r.poll());
    }
}
