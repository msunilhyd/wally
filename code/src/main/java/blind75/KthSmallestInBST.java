package blind75;

import com.sunil.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {

    public static void main(String[] args) {
        int k = 3;
        TreeNode root = new TreeNode(5);
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i=0; i<list.size(); i++) {
            if (i == k - 1)
                System.out.println(list.get(i));
        }
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }
}
