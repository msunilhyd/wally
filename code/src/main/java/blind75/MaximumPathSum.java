package blind75;

import com.sunil.TreeNode;

public class MaximumPathSum {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = Util.getTree();
        System.out.println(dfs(root));
        System.out.println(max);
    }

    public static int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));
        int curSum = root.data + leftSum + rightSum;

        max = Math.max(max, curSum);

        return Math.max(root.data + leftSum, root.data + rightSum);
    }
}
