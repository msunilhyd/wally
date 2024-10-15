package blind75;

import com.sunil.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {

    }

    public static boolean find(TreeNode root) {
        return recurse(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean recurse(TreeNode root, int max, int min) {
        if (root == null)
            return true;
        if (root.data <= min || root.data >= max)
            return false;
        return recurse(root.left, min, root.data) && recurse(root.right, root.data, max);
    }

}
