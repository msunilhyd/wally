package two;

import blind75.ListNode;
import blind75.Util;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = Util.getList();
        Util.printList(head);
        Util.printList(remove(head, 4));
    }

    public static ListNode remove(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = head;

        while(n > 0 && right != null) {
            n--;
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}

