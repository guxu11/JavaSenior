package com.guxu.algorithm.priorityQueue;

import org.testng.annotations.Test;

import java.util.*;

/*

 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int f1 = map.get(o1), f2 = map.get(o2);
                if (f1 > f2) return -1;
                else if (f1 < f2) return 1;
                else {
                    return o1.compareTo(o2);
                }
            }
        });
        for (String s: map.keySet()) {
            priorityQueue.add(s);
        }
        List<String> res = new ArrayList<>(priorityQueue.size());
        int i = 0;
        while (i < k) {
            res.add(priorityQueue.poll());
            i++;
        }
        return res;
    }

    @Test
    public void test() {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }
}
