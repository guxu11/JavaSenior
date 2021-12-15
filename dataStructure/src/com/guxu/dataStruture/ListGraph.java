package com.guxu.dataStruture;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author: guxu
 * @create: 2021/11/27
 * @description:
 */
public class ListGraph {
    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] visited;

    public ListGraph(int v) {
        graph = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        ListGraph g = new ListGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        System.out.println(g.graph.toString());

        g.dfs();
    }


    public void addEdge(int start, int end) {
        graph.get(start).add(end);
    }

    public void removeEdge(int start, int end) {
        graph.get(start).remove(end);
    }

    public void dfs() {
        visited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private void dfs(int v) {
        // 1. 打印当前的顶点值
        System.out.print(v + " -> ");
        // 2. visited置为true
        visited[v] = true;
        // 3. 获取当前的顶点的数组
        ArrayList<Integer> a = graph.get(v);
        Iterator<Integer> iterator = a.listIterator();
        // 4. 遍历当前节点
        while (iterator.hasNext()) {
            // 5. 获取与当前节点相连的下一个
            int next = iterator.next();
            // 6. 如果未被访问，则对其进行搜索
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}

