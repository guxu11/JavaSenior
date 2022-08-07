package com.guxu.other;

import java.util.*;

// Main class
class GFG {

    // Main driver method
    public static void main(String[] args)
    {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        priorityQueue.add("");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Collections.reverse(list);
        System.out.println(list);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1,1);
        treeMap.put(2,2);
        treeMap.put(3,3);
        System.out.println(treeMap.subMap(1, 3));
    }
}