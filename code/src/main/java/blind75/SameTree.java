package blind75;

import com.sunil.TreeNode;

public class SameTree {

    public static void main(String[] args) {

    }

    public static boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return false;
        if (p == null && q == null)
            return false;
        if (p.data == q.data)
            return sameTree(p.left, q.left) && sameTree(p.right, q.right);
        return false;
    }
}


