from typing import Optional, List
from math import inf

class ListNode:
    # Definition for a singly linked list node
    def __init__(self, val=0, next_node=None):
        self.val = val
        self.next = next_node

class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        # Initialize markers for previous and current nodes
        prev_node, curr_node = head, head.next

        # Initialize the first and last positions of critical points to None
        first_critical, last_critical = None, None

        index = 1 # Start from index 1 since we are checking from the second node
        min_distance, max_distance = inf, -inf # Set initial distances

        # Iterate through the linked list to find the critical points
        while curr_node.next:
            # Check if the curr_node is a critical point (local min or local max)
            if curr_node.val < min(prev_node.val, curr_node.next.val) or curr_node.val > max(prev_node.val, curr_node.next.val):
                # If this is the first critical point encountered, set both first and last 
                if last_critical is None:
                    first_critical = last_critical = index
                else:
                    # Update the minimum distance if the current critical point is closer to the previous critical point than other points
                    min_distance = min(min_distance, index - last_critical)
                    # Update the maximum distance from the current to the first critical point
                    max_distance = index - first_critical
                    # Update the last critical point to the index
                    last_critical = index
            # Move to the next index
            index += 1
            # Update the prev_node and curr_node to step through the list
            prev_node, curr_node = curr_node, curr_node.next

        # If no critical points or only one critical point found, return [-1, -1]
        # else, return the found minimum and maximum distances
        return [min_distance, max_distance] if first_critical != last_critical else [-1, -1]
