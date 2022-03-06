package com.guxu.algorithm.bfs.graph;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 815. 公交路线
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int count = 0;
        for (int[] route: routes) {
            for (int v: route) {
                if (!indexMap.containsKey(v)) {
                    indexMap.put(v, count);
                    count++;
                }
            }
        }
        System.out.println(indexMap);
        int size = indexMap.size();
        if (size == 0 || !(indexMap.containsKey(source) && indexMap.containsKey(target))) return -1;
        int[][] graph = new int[size][size];
        int busId = 1;
        for (int[] route: routes) {
            for (int p: route) {
                int pIndex = indexMap.get(p);
                for (int q: route) {
                    int qIndex = indexMap.get(q);
                    if (p == q) continue;
                    graph[pIndex][qIndex] = graph[qIndex][pIndex] = busId;
                }
            }
            busId++;
        }
        int res = 0;
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(indexMap.get(source));
        Set<Integer> visited = new HashSet<>();
//        Set<Integer> boarded = new HashSet<>();
//        int level = 1;
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int j = 0; j < level; j++) {
                int currPos = queue.poll();
                for (int i = 0; i < size; i++) {
                    if (i == currPos) continue;
                    int currBusId = graph[currPos][i];
                    if (currBusId == 0 || visited.contains(i)) continue;
                    if (i == indexMap.get(target)) return ++res;
//                    boarded.add(currBusId);
                    visited.add(i);
                    queue.addLast(i);
                    }
                }
            res++;
            }

        return -1;
    }
    @Test
    public void test() {
        int[][] routes = {
                {1,2,7},
                {3,6,7}
        };
        int source = 1;
        int target = 6;
        System.out.println(numBusesToDestination(routes, source, target));
    }
}
