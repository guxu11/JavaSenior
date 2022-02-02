package com.guxu.algorithm.hashmap;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map = new HashMap<>();
    public LRUCache(){}
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {

    }

    @Test
    public void test() {

    }
}
