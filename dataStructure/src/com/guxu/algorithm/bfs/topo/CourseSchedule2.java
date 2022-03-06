package com.guxu.algorithm.bfs.topo;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 210. 课程表 II
 */
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int[] res = new int[numCourses];
        int[] ingrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            ingrees[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Arrays.fill(res, -1);
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < ingrees.length; i++) {
            if (ingrees[i] == 0) {
                queue.addLast(i);
            }
        }
        int p = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;
            res[p] = course;
            p++;
            if (numCourses == 0) {
                return res;
            }
            for (int pre: adj.get(course)) {
                ingrees[pre]--;
                if (ingrees[pre] == 0) {
                    queue.addLast(pre);
                }
            }

        }
        return new int[]{};
    }

    @Test
    public void test() {
        int[][] prerequisites = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
//        int[][] prerequisites = {};
        int numCourses = 4;
        int[] res = findOrder(numCourses, prerequisites);
        for (int r: res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
