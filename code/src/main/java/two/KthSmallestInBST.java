package two;

import blind75.Util;
import com.sunil.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {

    public static void main(String[] args) {
        TreeNode root = Util.getTree();
        Util.printTree(root);
        System.out.println(find(root, 4));
    }

    public static int find(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k-1);
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }
}
