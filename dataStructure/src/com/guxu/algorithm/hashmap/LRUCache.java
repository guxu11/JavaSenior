package com.guxu.algorithm.hashmap;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private DoubleList doubleList;
    public LRUCache(){}
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.doubleList = new DoubleList();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (doubleList.size() == 0 || !map.containsKey(key)) return -1;
        Node n = map.get(key);
        int val = n.val;
        doubleList.remove(n);
        doubleList.addFirst(n);
//        map.put(key, n);
//        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node n = new Node(key, value);
        if (map.containsKey(key)) {
            doubleList.remove(map.get(key));
            doubleList.addFirst(n);
            map.put(key, n);
        } else {
            if (doubleList.size() == capacity) {
                Node last = doubleList.removeLast();
                map.remove(last.key);
            }
            doubleList.addFirst(n);
            map.put(key, n);
        }
    }

    class DoubleList {
        private int size;
        private Node head;
        private Node tail;
        public DoubleList() {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            this.size = 0;
        }
        public void addFirst(Node n) {
            n.next = head.next;
            n.prev = head;
            head.next.prev = n;
            head.next = n;
            size++;
        }

        public void remove(Node n) {
            int key = n.key;
            if (size == 0 || !map.containsKey(key)) return;
            if (n.next != null) n.next.prev = n.prev;
            if (n.prev != null) n.prev.next = n.next;
            map.remove(key);
            size--;
        }

        public Node removeLast () {
            if (size == 0) return null;
            Node n = tail.prev;
            n.prev.next = tail;
            tail.prev = n.prev;
            size--;
            return n;
        }

        public int size() {
            return size;
        }
    }

    class Node {
        int val, key;
        Node next, prev;
        public Node (int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    @Test
    public void test() {
        LRUCache l = new LRUCache(2);
        l.put(2,1);
        System.out.println(l.map);
        l.put(2,2);
        System.out.println(l.map);
//        System.out.println(size);
        System.out.println(l.get(2));
    }
}
