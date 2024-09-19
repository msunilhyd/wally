package com.sunil;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. If both p and q are null, return true
        if (p == null && q == null)
            return true;
        // 2. If either p or q is null, return false (one of them is null)
        if (p == null || q == null)
            return false;

        // 3. If p and q are not null, compare the value of p and q, if equal compare the left and right subtrees
        if (p.data == q.data)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        // 4. If p and q are not null, if the data is not equal, they must be different trees
        else
            return false;
    }
}
