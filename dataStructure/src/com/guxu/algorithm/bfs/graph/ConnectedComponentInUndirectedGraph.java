package com.guxu.algorithm.bfs.graph;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

/*
leetcode 323. 无向图中连通分量的数目
 */
public class ConnectedComponentInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int[][] graph = new int[n][n];
        for (int[] edge: edges) {
            int x = edge[0], y = edge[1];
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            res++;
            Deque<Integer> queue = new LinkedList<>();
            queue.addLast(i);
            while (!queue.isEmpty()) {
                int v = queue.pop();
                if (visited[v]) continue;
                visited[v] = true;
                int[] edgesV = graph[v];
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && graph[v][j] == 1) {
                        queue.addLast(j);
//                        visited[v2] = true;
                    }
                }
            }

        }

        return res;
    }

    @Test
    public void test() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2,3}, {3, 4}};
        System.out.println(countComponents(n, edges));
    }
}
