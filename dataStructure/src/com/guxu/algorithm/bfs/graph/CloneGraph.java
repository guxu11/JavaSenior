package com.guxu.algorithm.bfs.graph;

import com.guxu.algorithm.bfs.tree.TreeNode;
import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 133. 克隆图
 */
public class CloneGraph {
    // BFS
    public Node cloneGraphBFS(Node node) {
        if (node == null) return null;
        Deque<Node> queue = new LinkedList<>();
        Node head = new Node(node.val, new ArrayList<>());
        queue.addLast(node);
        Map<Node, Node> used = new HashMap<>();
        used.put(node, head);
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            for (Node n: currNode.neighbors) {
                if (!used.containsKey(n)) {
                    used.put(n, new Node(n.val, new ArrayList<>()));
                    queue.addLast(n);
                }
                used.get(n).neighbors.add(used.get(currNode));
            }
        }
        return used.get(node);
    }
    // DFS
    private Map<Node, Node> map = new HashMap<>();
    public Node cloneGraphDFS(Node node) {
        if (node == null) return node;
        if (map.containsKey(node)) return map.get(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        for (Node n : node.neighbors) {
            map.get(node).neighbors.add(cloneGraphDFS(n));
        }
        return map.get(node);
    }
    @Test
    public void test() {
        Node[] nodes = new Node[4];
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1, new ArrayList<>());
        }
        nodes[0].neighbors.add(nodes[1]);nodes[0].neighbors.add(nodes[2]);

        nodes[1].neighbors.add(nodes[0]);nodes[1].neighbors.add(nodes[3]);

        nodes[2].neighbors.add(nodes[0]);nodes[1].neighbors.add(nodes[3]);

        nodes[3].neighbors.add(nodes[1]);nodes[3].neighbors.add(nodes[2]);


    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
