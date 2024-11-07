package two;

import blind75.ListNode;
import blind75.Util;

public class ReorderList {

    public static void main(String[] args) {
        ListNode l = Util.getList();
        Util.printList(l);
        reorder(l);
    }

    public static ListNode reorder(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode l1 = head;

        while (l1 != null && l2 != null) {
            ListNode temp = l1.next;
            l1.next = l2;
            l2 = temp;
        }
        Util.printList(l1);
        return l2;
    }
}
