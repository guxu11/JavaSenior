package com.guxu.algorithm.hashmap;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
leetcode 350. 两个数组的交集 II
 */
public class IntersectionOfTwoArrays {
    private Map<Integer, Integer> map = new HashMap<>();
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        for (int num: nums1) {
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        for (int num: nums2) {
            if (map.containsKey(num)) {
                if (map.get(num) == 1) map.remove(num);
                else map.put(num, map.get(num) - 1);
                res.add(num);
            }
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    @Test
    public void test() {

    }
}
