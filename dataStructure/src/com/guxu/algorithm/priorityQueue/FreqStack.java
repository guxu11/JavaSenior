package com.guxu.algorithm.priorityQueue;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 895. 最大频率栈
 */
public class FreqStack {
    private PriorityQueue<Integer> priorityQueue;
    private Map<Integer, Stack<Integer>> map;
    private int index;
    public FreqStack() {
        priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Stack<Integer> s1 = map.get(o1);
                Stack<Integer> s2 = map.get(o2);
                int res =  s2.size() - s1.size();
                if (res != 0) return res;
                else {
                    if (s2.peek() > s1.peek()) return 1;
                    else return -1;
                }
            }
        });
        map = new HashMap<>();
        index = 0;
    }

    public void push(int val) {
        Stack<Integer> stack;
        if (!map.containsKey(val)) {
            stack = new Stack<Integer>(){{push(index);}};
            map.put(val, stack);
            priorityQueue.offer(val);
        } else {
            priorityQueue.remove(val);
            stack = map.get(val);
            stack.push(index);
            map.put(val, stack);
            priorityQueue.offer(val);

        }
        index++;
    }

    public int pop() {
        int val = priorityQueue.poll();
        Stack<Integer> stack = map.get(val);
        if (stack.size() > 1) {
            stack.pop();
            priorityQueue.offer(val);
        } else {
            map.remove(val);
        }
        return val;
    }

    @Test
    public void test() {
        map.put(1, new Stack<Integer>(){{push(1);}});
        Stack<Integer> stack = map.get(1);
        System.out.println(map.get(1).size());
        stack.pop();
        System.out.println(map.get(1).size());

    }
}
