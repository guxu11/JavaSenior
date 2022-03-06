package com.guxu.algorithm.bfs.topo;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
leetcode 310. 最小高度树
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int num = edges.length;
        List<Integer> res = new ArrayList<>();
        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }
        int[] inDegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int a = edge[0], b = edge[1];
            inDegree[a]++;
            inDegree[b]++;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                queue.addLast(i);
            }
        }
        int count = n;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currP = queue.poll();
                count--;
                for (int p: adj.get(currP)) {
                    inDegree[p]--;
                    if (inDegree[p] == 1) {
                        queue.addLast(p);
                    }
                }
            }
            if (count <= 2) {
                while (!queue.isEmpty()) res.add(queue.poll());
            }
        }
        return res;
    }

    @Test
    public void test() {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{0,3},{3,4},{4,5}};
        System.out.println(findMinHeightTrees(n, edges));
    }
}
