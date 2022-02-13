package com.guxu.algorithm.priorityQueue;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/*
leetcode 767. 重构字符串
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> priorityQueue = new PriorityQueue<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: map.keySet()) {
            priorityQueue.offer(c);
        }
        if (!priorityQueue.isEmpty() && map.get(priorityQueue.peek()) > Math.ceil((float)len / 2)) {
            return "";
        }
        char[] res = new char[len];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            char key = priorityQueue.poll();
            int count = map.get(key);
            for (int i = 0; i < count; i++) {
                while (res[index] != 0) {
                    if (index == len - 1) {
                        index = 0;
                        continue;
                    }
                    index++;
                }
                res[index] = key;
                if (i == count - 1) continue;
                index = index >= len - 2 ? 0 : index + 2;
            }
            index = index == len - 1 ? 0 : index + 1;
            System.out.println(new String(res));
        }
        return new String(res);
    }

    @Test
    public void test() {
        String s = "aabbcc";
        String res = reorganizeString(s);
        System.out.println(res);
    }
}
