package com.sunil;

import java.util.Arrays;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {


    // 1. Declare current and previous pointers
    ListNode curr = head;
    ListNode prev  = null;

    // 2. Iterate until current node is null
        while (curr != null) {
            // 2. 1 Declare next node that points to the next of the current node
            ListNode next = curr.next;
            // 2. 2 Set current to point to the previous
            curr.next = prev;
            // 2. 3 Change the variables so prev and curr move up one node
            prev = curr;
            curr = next;
        }
        // 3. return prev
        return prev;
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
