package com.guxu.algorithm.bfs.graph;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 752. 打开转盘锁
 */
public class OpenTheLock {
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

    @Test
    public void test() {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0001";

        System.out.println(openLock(deadends, target));
    }
}
