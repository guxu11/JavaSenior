package com.guxu.algorithm.hashmap;

import java.util.*;

/*
leetcode 380 O(1) 时间插入、删除和获取随机元素
 */
public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    Random rand = new Random();
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int last = list.get(list.size() - 1);
        int index = map.get(val);
        list.remove(index);
        list.add(index, last);
        list.remove(list.size() - 1);
        map.put(last, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
