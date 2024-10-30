package two;

import blind75.ListNode;
import blind75.Util;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = Util.getList();
        Util.printList(head);
        System.out.println();
        Util.printList(reverse(head));
    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
