package com.guxu.algorithm.bfs.topo;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 269. 火星词典
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        int n = words.length;
        StringBuilder res = new StringBuilder();
        if (n == 1 || (n == 2 && words[0].equals(words[1]))) {
            Set<Character> set = new HashSet<>();
            for (char c: words[0].toCharArray()) {
                if (set.add(c)) res.append(c);
            }
            return res.toString();
        }
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String first = words[i], second = words[i+1];
            if (first.length() > second.length() && first.startsWith(second)) {
//                System.out.println("in");
                return "";
            }
            int len = Math.min(first.length(), second.length());
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                char pre = first.charAt(j), next = second.charAt(j);
                if (!adj.containsKey(next)) adj.put(next, new HashSet<>());
                if (!adj.containsKey(pre)) adj.put(pre, new HashSet<Character>());
                if (!inDegree.containsKey(next)) inDegree.put(next, 0);
                if (!inDegree.containsKey(pre)) inDegree.put(pre, 0);
                if (flag) {
                    if (pre == next) {
                        continue;
                    }
                    flag = false;
                    if (adj.get(pre).add(next)) {
                        inDegree.put(next, inDegree.get(next) + 1);
                    }
                }
            }
            String temp = first.length() > second.length() ? first: second;
            for (int j = len; j < temp.length(); j++) {
                if (!inDegree.containsKey(temp.charAt(j))) inDegree.put(temp.charAt(j), 0);
                if (!adj.containsKey(temp.charAt(j))) adj.put(temp.charAt(j), new HashSet<>());
            }
        }

        Deque<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        for (Map.Entry<Character, Integer> entry: inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.addLast(entry.getKey());
                visited.add(entry.getKey());
            }
        }
//        System.out.println(queue);
//        System.out.println(inDegree);
//        System.out.println(adj);
        while (!queue.isEmpty()) {
            char c = queue.poll();
            res.append(c);
            for (char ch: adj.get(c)) {
                inDegree.put(ch, inDegree.get(ch) - 1);
                int in = inDegree.get(ch);
                if (in == 0 && !visited.contains(ch)) {
                    queue.addLast(ch);
                    visited.add(ch);
                }
            }
        }
//        System.out.println(res);
        return res.length() == inDegree.size() ? res.toString() : "";
    }

    @Test
    public void test() {
        String[] words = {"wrt","wrf","er","ett","rftt","te"};
//        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrder(words));
    }
}
