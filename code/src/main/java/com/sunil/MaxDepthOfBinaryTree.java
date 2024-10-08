package com.sunil;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        // 1. If root is null, return 0
        if (root == null)
            return 0;
        // 2. If root is not null, return 1 + max of left and right subtrees
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1 ;
    }
}

