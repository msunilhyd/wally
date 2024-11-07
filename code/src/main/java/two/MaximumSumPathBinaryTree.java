package two;

import blind75.Util;
import com.sunil.TreeNode;

public class MaximumSumPathBinaryTree {

    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = Util.getTree();
        find(root);
        System.out.println(maxSum);
    }

    public static int find(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = Math.max(0, find(root.left));
        int rightSum = Math.max(0, find(root.right));

        int curSum = leftSum + rightSum + root.data;
        maxSum = Math.max(maxSum, curSum);

        return root.data + Math.max(leftSum, rightSum);
    }
}
