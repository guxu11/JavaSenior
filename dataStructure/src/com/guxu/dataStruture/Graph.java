package com.guxu.dataStruture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public static void main(String[] args) {

        int n = 4;
        String Vertexs[] = {"1", "2", "3", "4"};//, "5", "6", "7", "8"};
        Graph graph = new Graph(n);
        for(String vertex: Vertexs) {
            graph.insertVertex(vertex);
        }

        //插入图的节点
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
//        graph.insertEdge(1, 4, 1);
//        graph.insertEdge(3, 7, 1);
//        graph.insertEdge(4, 7, 1);
//        graph.insertEdge(2, 5, 1);
//        graph.insertEdge(2, 6, 1);
//        graph.insertEdge(5, 6, 1);

        //遍历图
        graph.showGraph();

        System.out.println("深度度优先遍历");
        graph.dfs();
//        System.out.println("广度优先遍历");
//        graph.bfs();

    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }


    public int getFirstNeighbor(int index) {
        for(int j = 0; j < vertexList.size(); j++) {
            if(edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for(int j = v2 + 1; j < vertexList.size(); j++) {
            if(edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历
    private void dfs(boolean[] isVisited, int i) {
       // TODO
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int weight = getFirstNeighbor(i);
        while (weight != -1) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
            weight = getNextNeighbor(i, weight);
        }

    }

    public void dfs() {
       // TODO
        isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //广度优先遍历
    private void bfs(boolean[] isVisited, int i) {
       // TODO
    }

    public void bfs() {
       // TODO
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    //遍历
    public void showGraph() {
        for(int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //添加邻接矩阵
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //插入权值
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}

