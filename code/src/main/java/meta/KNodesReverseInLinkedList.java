package meta;

import blind75.ListNode;
import blind75.Util;

public class KNodesReverseInLinkedList {

    public static void main(String[] args) {
        ListNode head = Util.getList();
        Util.printList(head);
        Util.printList(reverseKGroup(head, 3));
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prevTail = null;
        ListNode newHead = null;

        while (curr != null) {
            ListNode tail = curr;
            ListNode prev = null;

            int count = 0;
            // Check if there are at least k nodes to reverse
            while (curr != null && count < k) {
                curr = curr.next;
                count++;
            }

            if (count == k) {
                curr = tail;
                for (int i=0; i<k; i++) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }

                // New head for the first time
                if (newHead == null) {
                    newHead = prev;
                }

                // Connect with the previous part
                if (prevTail != null) {
                    prevTail.next = prev;
                }
                prevTail = tail;
            } else {
                // If we don't have k nodes left, just connect the remaining nodes
                if (prevTail != null) {
                    prevTail.next = tail;
                }
            }
        }
        return newHead != null ? newHead : head;
    }
}
