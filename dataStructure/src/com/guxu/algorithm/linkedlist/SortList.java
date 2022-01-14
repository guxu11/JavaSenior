package com.guxu.algorithm.linkedlist;

import org.testng.annotations.Test;

/*
leetcode 148 排序链表
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        return mergeTwoLists(sortList(left), sortList(right));
    }

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
        int[] arr = {4, 2, 1, 3};
        ListNode head = ListNode.arrayToList(arr);
        ListNode res = sortList(head);
        ListNode.printList(res);
    }
}
