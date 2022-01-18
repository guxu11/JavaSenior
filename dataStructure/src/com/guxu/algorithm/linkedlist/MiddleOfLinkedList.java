package com.guxu.algorithm.linkedlist;

import org.testng.annotations.Test;

/*
leetcode 876 链表的中间节点
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    @Test
    public void test() {
        int[] nums = {1,2,3,4,5};
        ListNode list = ListNode.arrayToList(nums);
        ListNode.printList(middleNode(list));
    }
}
