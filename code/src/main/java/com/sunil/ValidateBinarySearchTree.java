package com.sunil;

public class ValidateBinarySearchTree {

    // 1. Keep a global variable to store the last
    private Integer last = null;

    // Method to check if BST is valid
    public boolean isValidBST(TreeNode root) {
        //1. Call helper method that checks if valid
        return checkBST(root);
    }

    // Method to check if BST is valid. Also known as inorder sort
    private boolean checkBST(TreeNode root) {
        // 1. If root is null, return True
        if (root == null)
            return true;

        // 2. Check if left subtree is valid
        if (!checkBST(root.left))
            return false;

        // 3. Check if root is greater than last
        if (last != null && root.data <= last)
            return false;

        // 4. update last
        last = root.data;

        // 5. Check if right subtree is valid
        if (!checkBST(root.right))
            return false;

        // 6. If passes all checks return true for trees/subtrees
        return true;
    }
}
