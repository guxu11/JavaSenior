package com.guxu.algorithm.bfs.topo;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
leetcode 207. 课程表
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre: prerequisites) {
            indegrees[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.addLast(i);
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur: adj.get(pre)) {
                indegrees[cur]--;
                if (indegrees[cur] == 0) queue.addLast(cur);
            }
        }
        return numCourses == 0;
    }
    @Test
    public void test() {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

}
