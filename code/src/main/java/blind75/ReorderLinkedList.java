package blind75;

public class ReorderLinkedList {

    public static void main(String[] args) {
        ListNode head = Util.getList();
        Util.printList(reorder(head));
    }
    public static ListNode reorder(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode temp;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode h1 = head;
        ListNode h2 = prev;
        while (h2 != null) {
            temp = h1.next;
            h1.next = h2;
            h1 = h2;
            h2 = temp;
        }
        return head;
    }
}
