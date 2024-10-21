package blind75;

import com.sunil.TreeNode;

public class SubTreeOfAnotherTree {

    public static TreeNode subRoot = Util.getTree();

    public static void main(String[] args) {
        TreeNode root = Util.getTree();
        System.out.println(dfs(root));
    }

    public static boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null || root.data != subRoot.data)
            return false;
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }

    public static boolean dfs(TreeNode root) {
        if (root == null)
            return false;
        if (isSame(root, subRoot))
            return true;
        return isSame(root.left, subRoot) || isSame(root.right, subRoot);
    }
}
