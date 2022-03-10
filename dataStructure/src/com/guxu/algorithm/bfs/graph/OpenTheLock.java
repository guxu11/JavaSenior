package com.guxu.algorithm.bfs.graph;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 752. 打开转盘锁
 */
public class OpenTheLock {
    // 朴素BFS
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) return 0;
        Set<String> deadLocks = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if (deadLocks.contains(start)) return -1;
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Deque<String> queue = new LinkedList<>();
        queue.addLast(start);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String curr = queue.poll();
                char[] currs = curr.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char c = currs[i];
                    currs[i] = c == '0' ? '9' : (char) ( c - 1);;
                    String newS1 = new String(currs);
                    currs[i] = c == '9' ? '0' : (char) (c + 1);
                    String newS2 = new String(currs);
                    currs[i] = c;
                    if (newS1.equals(target) || newS2.equals(target)) return ++res;
                    for (String newS: new String[]{newS1, newS2}) {
                        if (!deadLocks.contains(newS) && !visited.contains(newS)) {
                            queue.addLast(newS);
                            visited.add(newS);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    // 双向BFS
    Set<String> forbid;
    String s, t;
    public int openLock2(String[] deadends, String target) {
        forbid = new HashSet<>(Arrays.asList(deadends));
        s = "0000"; t = target;
        if (s.equals(t)) return 0;
        if (forbid.contains(s)) return -1;
        return bfs();
    }

    private int bfs() {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map1.put(s, 0); map2.put(t, 0);
        Deque<String> queue1 = new LinkedList<>();
        Deque<String> queue2 = new LinkedList<>();
        queue1.addLast(s); queue2.addLast(t);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int res = -1;
            if (queue1.size() <= queue2.size()) {
                res = update(queue1, map1, map2);
            } else {
                res = update(queue2, map2, map1);
            }
            if (res != -1) return res;
        }
        return -1;
    }
    private int update(Deque<String> queue, Map<String, Integer> map1, Map<String, Integer> map2) {
        int size = queue.size();
        for (int k = 0; k < size; k++) {
            String s = queue.poll();
            char[] chars = s.toCharArray();
            for (int i = 0; i < 4; i++) {
                char c = chars[i];
                for (int j = -1; j <= 1; j++) {
                    if (j == 0) continue;
                    char newChar = (char) (c + j);
                    if (newChar < '0') newChar = '9';
                    else if (newChar > '9') newChar = '0';
                    char[] clone = chars.clone();
                    clone[i] = newChar;
                    String newString = new String(clone);
                    if (forbid.contains(newString)) continue;
                    if (map1.containsKey(newString)) continue;
                    if (map2.containsKey(newString)) {
                        return map1.get(s) + 1 + map2.get(newString);
                    } else {
                        map1.put(newString, map1.get(s) + 1);
                        queue.addLast(newString);
                    }
                }
            }
        }

        return -1;
    }

    @Test
    public void test() {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0001";

        System.out.println(openLock2(deadends, target));
    }
}
