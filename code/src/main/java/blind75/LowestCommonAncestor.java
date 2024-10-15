package blind75;

import com.sunil.TreeNode;

public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    public static TreeNode findLCA(TreeNode root, int p, int q) {
        if (p < root.data && q < root.data)
            return findLCA(root.left, p, q);
        else if (p > root.data && q > root.data)
            return findLCA(root.right, p, q);
        else
            return root;
    }
}
