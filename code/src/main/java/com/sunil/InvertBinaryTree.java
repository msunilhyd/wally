package com.sunil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        // 1. If root is null, no tree return null
        if (root == null)
            return null;

        // 2. Create a queue to store the nodes and add the root to the queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Breadth first search
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 3.1 Swap the left and right children
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            // 3.2 Add the children to the queue
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
