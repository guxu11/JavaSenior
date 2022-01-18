package com.guxu.algorithm.linkedlist;

import org.testng.annotations.Test;

/*
leetcode 92 反转链表2
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode prev = null, curr = head;
        ListNode leftNode = null , rightNode = null, currTail = head;
        int count = 1;
        while (count <= right) {
            if (count < left) {
                prev = curr;
                curr = curr.next;
                leftNode = prev;
                currTail = curr;
                count++;
            } else {
                if (count == left) prev = null;
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
                if (count > right) {
                    rightNode = next;
                    curr = prev;
                }
            }
        }
        if (leftNode == null) {
            currTail.next = rightNode;
            return curr;
        }
        leftNode.next = curr;
        currTail.next = rightNode;
        ListNode.printList(curr);
        return head;
    }
    @Test
    public void test() {
        int[] nums = {3,5};
        ListNode list = ListNode.arrayToList(nums);
        ListNode.printList(reverseBetween(list, 1, 2));
    }

}
