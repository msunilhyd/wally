package two;

import blind75.ListNode;
import blind75.Util;

public class ReorderLinkedList {

    public static void main(String[] args) {
        ListNode head = Util.getList();
        Util.printList(reorder(head));
    }

    public static ListNode reorder(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode h1 = head;
        ListNode h2 = prev;

        while (h2 != null) {
            ListNode temp = h1.next;
            h1.next = h2;
            h1 = h2;
            h2 = temp;
        }
        return head;
    }
}
