package com.sunil;

public class MergeTwoSortedLinkedLists {

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        // 1. Declare return list and dummy node pointing to list
        ListNode returnList = new ListNode(0);
        ListNode dummy = returnList;

        // 2. Iterate until list one or list two is empty
        while (l1 != null && l2 != null) {
            // 2.1 If the value of list 2 head is smaller than 1 add list 2 head to
            // return list and move list 2 head one pointer forward
            if (l1.data > l2.data) {
                dummy.next = l2;
                l2 = l2.next;
            }
            // 2.2 If value of list1 head is smaller than list2 add list1 head to
            // return list and move list2 head one pointer forward
            else {
                dummy.next = l1;
                l1 = l1.next;
            }
            // 2.3 Move dummy pointer one forward
            dummy = dummy.next;
        }
        // 3. If list1 is empty add all of list2 to the end of return
        if (l1 == null)
            dummy.next = l2;
        // 4. If list2 is empty add all of list1 to the end of return
        if (l2 == null)
            dummy.next = l1;

        // 5. Set return list one node forward to get rid of initial dummy declaration and return list
        returnList = returnList.next;
        return returnList;

    }
}
