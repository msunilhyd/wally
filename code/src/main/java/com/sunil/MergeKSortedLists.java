package com.sunil;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        //1. Create a priority queue to function as a minimum heap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> {
            return node1.data - node2.data;
        });
        //2. Iterate through all different linked lists
        for (ListNode node : lists) {
            // 2.1 Iterate through all the elements of the current linked list
            while (node != null) {
                // 2.1.1 If null we finished the list, continue to the next list
                if (node == null)
                    continue;
                // 2.1.2 Add current node to minHeap
                minHeap.offer(node);
                // 2.1.3 Create a node to cache current node and move current node forward one element
                ListNode cache = node;
                node = node.next;

                // 2.1.4 Set the next pointer of the cache element to null
                cache.next = null;
            }
        }
        //3. Set a dummy
        ListNode returnList = new ListNode();
        ListNode head = returnList;
        //4. Iterate through minHeap and add the minimum element to the return list
        while (!minHeap.isEmpty()) {
            // 4.1 Add the minimum element to the return list
            ListNode lowest = minHeap.poll();
            // 4.3 Move head forward one element
            head.next = lowest;
            head = head.next;
        }
        //5. Return the return list
        return returnList.next;
    }
}
