package two;

import blind75.ListNode;
import blind75.Util;

public class Merge2SortedLists {

    public static void main(String[] args) {
        ListNode l1 = Util.getList();
        ListNode l2 = Util.getList();
        l2.data = 0;
        l2.next.next.next.data = 15;
        l2.next.next.data = 13;
        Util.printList(merge(l1, l2));
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
               l2 = l2.next;
            }
            temp = temp.next;
        }
        while (l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
