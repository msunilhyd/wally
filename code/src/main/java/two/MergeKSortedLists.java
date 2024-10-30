package two;

import blind75.ListNode;
import blind75.Util;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {
        List<ListNode> kLists = new ArrayList<>();
        kLists.add(Util.getList());
        kLists.add(Util.getList());
        kLists.add(Util.getList());
        Util.printList(mergeKSortedLists(kLists));
    }

    public static ListNode mergeKSortedLists(List<ListNode> list) {
        if (list.size() == 1)
            return list.get(0);

        ListNode head = null;

        for (ListNode node : list) {
            head = merge(node, head);
        }
        return head;
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
