package blind75;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode root = Util.getList();
        Util.printList(remove(root, 2));
    }

    public static ListNode remove(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = head;

        while (second != null && n > 0) {
            second = second.next;
            n--;
        }

        while (second != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
