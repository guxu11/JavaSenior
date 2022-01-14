package com.guxu.algorithm.linkedlist;

import org.testng.annotations.Test;

/*
leetcode 21 合并两个有序链表
 */
public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = new ListNode();
        ListNode p0 = head;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p0.next = p1;
                p1 = p1.next;
            } else {
                p0.next = p2;
                p2 = p2.next;
            }
            p0 = p0.next;
        }
        p0.next = p1 != null ? p1: p2;
        return head.next;
    }

    @Test
    public void test() {
        int[] list1 = {1, 2, 4};
        int[] list2 = {1, 3, 4};
        ListNode l1 = ListNode.arrayToList(list1);
        ListNode l2 = ListNode.arrayToList(list2);
        ListNode res = mergeTwoLists(l1, l2);
        ListNode.printList(res);
    }
}
