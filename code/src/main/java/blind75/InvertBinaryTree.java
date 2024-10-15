package blind75;

import com.sunil.TreeNode;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = Util.getTree();
        Util.printTree(root);
        invert(root);
        Util.printTree(root);
    }

    public static void invert(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }
}
