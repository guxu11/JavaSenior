package com.guxu.algorithm.slideWindow;

import org.testng.annotations.Test;

import java.util.*;

/*
leetcode 239. 滑动窗口最大值
 */
public class MaxOfSlidingWindow {
    // TreeMap 518ms
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res =new int[nums.length - k + 1];
        int left = 0, right = left + k - 1;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = left; i <= right; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
//        System.out.println(treeMap);
//        System.out.println(treeMap.lastKey());
        int i = 0;
        while (right < nums.length) {
//            System.out.println(treeMap);
            res[i] = treeMap.lastKey();
            if (right == nums.length - 1)break;
            right++;
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
            if (treeMap.get(nums[left]) == 0) treeMap.remove(nums[left]);
            left++;
            i++;
        }
        return res;
    }
    // 优先队列 82ms
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        res[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] < i - k + 1) {
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }


    // 单调队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.addLast(i);
        }
        res[0] = nums[q.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.addLast(i);
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }
            res[i - k + 1] = nums[q.peekFirst()];
        }
        return res;
    }
    @Test
    public void test() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow2(nums, k);
        for (int r: res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
