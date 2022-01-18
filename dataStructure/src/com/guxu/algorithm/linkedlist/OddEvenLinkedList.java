package com.guxu.algorithm.linkedlist;

import org.testng.annotations.Test;

/*
leetcode 328 奇偶链表
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode evenFirst = head.next, oddLast = null;
        ListNode oddP = head, evenP = head.next;
        while (true) {
            oddP.next = evenP.next;
            if (oddP.next == null) {
                oddLast = oddP;
                break;
            }
            oddP = oddP.next;
            evenP.next = oddP.next;
            if (evenP.next == null) {
                oddLast = oddP;
                break;
            }
            evenP = oddP.next;
        }
        oddLast.next = evenFirst;
        return head;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4};
        ListNode res = oddEvenList(ListNode.arrayToList(nums));
        ListNode.printList(res);
    }
}
