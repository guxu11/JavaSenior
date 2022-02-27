package com.guxu.algorithm.bfs.tree;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
leetcode 297. 二叉树的序列化与反序列化
 */
public class SerializeAndDeserializeBinaryTree {
    // dfs
    public String serializeDFS(TreeNode root) {
        if (root == null) return "X,";
        return root.val + "," + serializeDFS(root.left)  + serializeDFS(root.right);
    }
    public TreeNode deserializeDFS(String data) {
        String[] list = data.split(",");
        Deque<String> queue = new LinkedList<>(Arrays.asList(list));
        return deserializeDFS(queue);
    }
    private TreeNode deserializeDFS(Deque<String> queue) {
        String s = queue.poll();
        if ("X".equals(s)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserializeDFS(queue);
        node.right = deserializeDFS(queue);
        return node;
    }

    // bfs
    public String serializeBFS(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.toString();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null,");
                    continue;
                }
                sb.append(node.val + ",");
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserializeBFS(String data) {
        if (data == null || "".equals(data)) return null;
        String[] list = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(list[++i])) {
                node.left = new TreeNode(Integer.parseInt(list[i]));
                queue.addLast(node.left);
            }
            if (!"null".equals(list[++i])) {
                node.right = new TreeNode(Integer.parseInt(list[i]));
                queue.addLast(node.right);
            }
        }
        return root;
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
        String data = serializeBFS(root);
        System.out.println(data);
        System.out.println(serializeBFS(deserializeBFS(data)));
    }
}
