package com.guxu.dataStruture;

/**
 * @author: guxu
 * @create: 2021/11/1
 * @description: 优先队列
 */
public class MyPriorityQueue {
    static class Node {
        int value;
        int priority;
        Node next;

        public Node(int v, int p) {
            value = v;
            priority = p;
        }
    }

    Node head = null;

    public MyPriorityQueue() {

    }
    public MyPriorityQueue(int v, int p) {
        head = new Node(v, p);
    }

    public void push(int v, int p) {
        Node newNode = new Node(v, p);
        if(head == null) {
            head = newNode;
            return;
        }
        if(p > head.priority) {
            newNode.next = head;
            head = newNode;
        }else {
            Node curr = head;
            while (curr.next != null && curr.next.priority > p) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    public Node pop() {
        if(head == null) {
            return null;
        }
        Node item = head;
        head = head.next;
        return item;
    }

    public Node peek() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
