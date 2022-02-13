package com.guxu.algorithm.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import com.guxu.algorithm.linkedlist.ListNode;
import org.testng.annotations.Test;

/*
leetcode 23. 合并K个升序链表
 */
public class MergeKLargestElements {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode head: lists) {
            while (head != null) {
                priorityQueue.add(head);
                head = head.next;
            }
        }
        if (priorityQueue.isEmpty()) return null;
        ListNode head = new ListNode();
        ListNode p = head;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            node.next = null;
            p.next = node;
            p = p.next;
        }
        return head.next;

    }

}

