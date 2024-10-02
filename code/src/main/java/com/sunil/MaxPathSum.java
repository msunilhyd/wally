package com.sunil;

public class MaxPathSum {

    // Global variable to store the max path sum
    int max = Integer.MIN_VALUE;

    // Method to find the max path sum in a binary tree
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    // Helper method to find the max Path Sum
    int helper(TreeNode root) {
        // 1. If root is null, return 0
        if (root == null)
            return 0;
        // 2. If root is not null, find the max path in the left and the right subtrees
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        // 3. Update the max sum path
        max = Math.max(max, root.data + left + right);

        // 4. Return the max path sum of the left or right subtree
        return root.data + Math.max(left, right);
    }
}
