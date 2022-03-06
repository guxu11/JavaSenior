package com.guxu.algorithm.bfs.topo;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 444. 序列重建
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int m = sequences.size();
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (List<Integer> seq: sequences) {
            if (seq.size() == 1) {
                if (!adj.containsKey(seq.get(0))) adj.put(seq.get(0), new HashSet<>());
                continue;
            }
            for (int i = 0; i < seq.size() - 1; i++) {
                int pre = seq.get(i), next = seq.get(i+1);
                if (!adj.containsKey(pre)) adj.put(pre, new HashSet<>());
                if (!adj.containsKey(next)) adj.put(next, new HashSet<>());
                if (!inDegree.containsKey(pre)) inDegree.put(pre, 0);
                if (!inDegree.containsKey(next)) inDegree.put(next, 0);
                if (adj.get(pre).add(next)) inDegree.put(next, inDegree.get(next) + 1);
            }
        }
//        System.out.println(adj);
//        System.out.println(inDegree);
        Deque<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int k: inDegree.keySet()) {
            if (inDegree.get(k) == 0) {
                queue.addLast(k);
                count++;
            }
            if (count > 1) return false;
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (nums[index] != curr) return false;
            index++;
            int c = 0;
            for (int next: adj.get(curr)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    c += 1;
                    queue.addLast(next);
                    if (c > 1) return false;
                }
            }

        }

        return true;
    }

    @Test
    public void test() {
        int[] nums = {4,1,5,2,6,3};
        Integer[][] seqs = {
                {5,2,6,3},{4,1,5,2}
        };
        List<List<Integer>> sequences = new ArrayList<>();
        for (Integer[] seq: seqs) {
            sequences.add(Arrays.asList(seq));
        }
        System.out.println(sequenceReconstruction(nums, sequences));
    }
}
