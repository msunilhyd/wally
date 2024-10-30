package two;

import blind75.Util;
import com.sunil.TreeNode;

import java.io.FilterOutputStream;

public class ValidBST {

    public static void main(String[] args) {
        TreeNode root = Util.getTree();
        root.left.data = 10;
        System.out.println(recurse(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static boolean recurse(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.data < min || root.data > max)
            return false;
        return recurse(root.left, min, root.data) && recurse(root.right, root.data, max);
    }
}
