package meta;

import blind75.ListNode;
import blind75.Util;

import java.util.Arrays;

public class CriticalPoints {

    public static void main(String[] args) {
        ListNode head = Util.getList();
        Util.printList(head);
        System.out.println(Arrays.toString(find(head)));
    }

    private static int[] find(ListNode head) {
        ListNode curr = head.next;
        ListNode prev = head;
        int index = 1;

        int firstCriticalNode = 0;
        int lastCriticalNode = 0;

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        while (curr.next != null) {
            if (curr.data > Math.max(curr.next.data, prev.data) || curr.data < Math.min(curr.next.data, prev.data)) {
                if (lastCriticalNode == 0) {
                    firstCriticalNode = index;
                    lastCriticalNode = index;
                } else {
                    minVal = Math.min(minVal, index - lastCriticalNode);
                    maxVal = index - firstCriticalNode;
                    lastCriticalNode = index;
                }
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        if (firstCriticalNode == lastCriticalNode)
            return new int[]{-1, -1};
        else return new int[]{minVal, maxVal};
    }
}
