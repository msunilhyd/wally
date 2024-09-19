package com.sunil;

public class ReorderList {

    public void reorderList(ListNode head) {
        //1. If head is null return
        if (head == null)
            return;
        //2. Find the middle of the list
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            //2.1 Move slow pointer one element forward and fast pointer two elements forward
            slow = slow.next;
            fast = fast.next.next;
        }
        //3. Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow.next;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        //4. Declare head2 to point to the beginning of the second half of the list
        ListNode head2 = prev;
        //5. Declare slow.next to be null to avoid cyclic list
        slow.next = null;

        //6. Merge the 2 lists. Start by iterating until one list is empty
        while (head != null && head2 != null) {
            //6.1 Create a temporary node to cache the head
            ListNode tmp1 = head.next;
            //6.2 Create a temporary node to cache the head2
            ListNode tmp2 = head2.next;
            //6.3 Set the head2 to point to head's next element
            head2.next = head.next;
            //6.4 Set the head to point to head2
            head.next = head2;
            //6.5 Head is now head2's temp cache and head2 is now head's tmp cache
            head = tmp1;
            head2 = tmp2;
        }
    }
}
