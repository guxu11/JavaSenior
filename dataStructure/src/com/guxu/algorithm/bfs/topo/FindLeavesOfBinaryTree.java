package com.guxu.algorithm.bfs.topo;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 366. 寻找二叉树的叶子节点
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        Map<TreeNode, Integer> inDegree = new HashMap<TreeNode, Integer>(){{put(root, 1);}};
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            int val = currNode.val;
            if (!adj.containsKey(currNode)) adj.put(currNode, new ArrayList<>());
            if (!inDegree.containsKey(currNode)) inDegree.put(currNode, 0);
            if (currNode.left != null) {
                TreeNode left = currNode.left;
                queue.addLast(left);
                if (!adj.containsKey(left)) adj.put(left, new ArrayList<>());
                adj.get(left).add(currNode);
                inDegree.put(left, inDegree.getOrDefault(left, 0) + 1);
                adj.get(currNode).add(left);
                inDegree.put(currNode, inDegree.get(currNode) + 1);
            }
            if (currNode.right != null) {
                TreeNode right = currNode.right;
                queue.addLast(right);
                if (!adj.containsKey(right)) adj.put(right, new ArrayList<>());
                adj.get(right).add(currNode);
                inDegree.put(right, inDegree.getOrDefault(right, 0) + 1);
                adj.get(currNode).add(right);
                inDegree.put(currNode, inDegree.get(currNode) + 1);
            }
        }
        Deque<TreeNode> queue2 = new LinkedList<>();
        for (TreeNode p: inDegree.keySet()) {
            if (inDegree.get(p) == 1) queue2.addLast(p);
        }
        while (!queue2.isEmpty()) {
            int size = queue2.size();
            List<Integer> r = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currP = queue2.poll();
                r.add(currP.val);
                for (TreeNode next: adj.get(currP)) {
                    inDegree.put(next, inDegree.get(next) - 1);
                    if (inDegree.get(next) == 1) queue2.addLast(next);
                }
            }
            res.add(r);
        }
        return res;

    }

    @Test
    public void test() {

    }
}

 // Definition for a binary tree node.
class TreeNode {
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
}
