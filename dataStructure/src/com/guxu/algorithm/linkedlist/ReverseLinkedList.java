package com.guxu.algorithm.linkedlist;

import org.testng.annotations.Test;

/*
leetcode 206 反转链表
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null, curr = head;
        while (curr.next != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5};
        ListNode list = ListNode.arrayToList(nums);
        ListNode.printList(reverseList(list));
    }
}
