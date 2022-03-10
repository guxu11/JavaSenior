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
        Map<Integer, List<Integer>> busRoute = new HashMap<>();
//        Map<Integer, boolean[]> visited = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int pos: routes[i]) {
                if (!busRoute.containsKey(pos)) busRoute.put(pos, new ArrayList<>());
//                if (!visited.containsKey(pos)) visited.put(pos, new boolean[n]);
                busRoute.get(pos).add(i);
            }
        }
        if (!busRoute.containsKey(source) || !busRoute.containsKey(target)) return -1;
        // System.out.println(busRoute);
        Deque<int[]> queue = new LinkedList<>();
        for (int bus: busRoute.get(source)) {
            queue.addLast(new int[]{source, bus, 1});
//            visited.get(source)[bus] = true;
        }
        Set<Integer> visitedBus = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currPosAndBus = queue.poll();
                int currPos = currPosAndBus[0], currBus = currPosAndBus[1], currRes = currPosAndBus[2];
                visitedBus.add(currBus);
                for (int pos : routes[currBus]) {
                    if (pos == target) return currRes;
                    for (int bus: busRoute.get(pos)) {
//                        if (!visited.get(pos)[bus]) {
                            if (bus == currBus) queue.addLast(new int[]{pos, bus, currRes});
                            else {
                                if (!visitedBus.contains(bus)){
                                    queue.addLast(new int[]{pos, bus, currRes+1});
                                    visitedBus.add(currBus);
                                }
                            }
//                            visited.get(pos)[bus] = true;
//                        }
                    }
                }
            }

        }
        return -1;
    }
    @Test
    public void test() {
        int[][] routes = {
                {1,9,12,20,23,24,35,38},{10,21,24,31,32,34,37,38,43},{10,19,28,37},{8},{14,19},{11,17,23,31,41,43,44},{21,26,29,33},{5,11,33,41},{4,5,8,9,24,44}

        };
        int source = 37;
        int target = 28;
        System.out.println(numBusesToDestination(routes, source, target));
    }
}
