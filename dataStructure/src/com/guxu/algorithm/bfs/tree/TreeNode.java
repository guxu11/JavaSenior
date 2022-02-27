package com.guxu.algorithm.bfs.tree;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public String serialize(TreeNode root) {
        if (root == null) return "null,";
        return root.val + "," + serialize(root.left)  + serialize(root.right);
    }
    public TreeNode deserialize(String data) {
        String[] list = data.split(",");
        Deque<String> queue = new LinkedList<>(Arrays.asList(list));
        return deserialize(queue);
    }
    private TreeNode deserialize(Deque<String> queue) {
        String s = queue.poll();
        if ("null".equals(s)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        TreeNode l3 = new TreeNode(4);
        TreeNode l4 = new TreeNode(5);
        root.left = l1;
        root.right = l2;
        l2.left = l3;
        l2.right = l4;
        String data = serialize(root);
        System.out.println(data);
        System.out.println(deserialize(data));
    }
}
