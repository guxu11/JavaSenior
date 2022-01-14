package com.guxu.algorithm.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode arrayToList(int[] arr) {
        if (arr.length == 0) return new ListNode();
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            p.next = temp;
            p = temp;
        }
        return head;
    }

    public static void printList(ListNode l) {
        if (l == null) {
            System.out.println("");
            return;
        }
        StringBuilder res = new StringBuilder();
        while (l != null) {
            System.out.print(l.val + " -> ");
            l = l.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l = arrayToList(new int[] {1,2,3});
        printList(l);
    }
}
