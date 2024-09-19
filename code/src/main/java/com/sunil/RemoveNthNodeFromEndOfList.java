package com.sunil;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthNodeFromEnd(ListNode head, int n) {

        //1. Create a dummy node pointing to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //2. Create two pointers both pointing to the dummy node
        ListNode first = dummy;
        ListNode second = dummy;

        //3. Move the first pointer n elements forward
        for (int i=0; i<n+1; i++) {
            first = first.next;
        }
        //4. Move the first pointer and second pointer together until first pointer is null
        while(first != null) {
            first = first.next;
            second = second.next;
        }

        //5. Push second's pointer one element forward
        second.next = second.next.next;
        return dummy.next;
    }
}
