package blind75;

import java.util.List;

public class MergeTwoSortedLists {

    // Time Complexity = O(m + n)

    public static void main(String[] args) {
        ListNode l1 = Util.getList();
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(6);

        one.next = two;
        two.next = three;
        Util.printList(merge(l1, one));
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 != null)
            dummy.next = l1;
        else dummy.next = l2;

        return head.next;
    }
}
