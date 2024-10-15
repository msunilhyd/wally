package blind75;

import com.sunil.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(7);

        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(8);

        right.left = rightLeft;
        right.right = rightRight;

        root.left = left;
        root.right = right;
        System.out.println(findDepthBFS(root));
    }

    public static int findDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }

    public static int findDepthBFS(TreeNode root) {
        if (root == null)
            return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            for (int i=0; i<len; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return depth;
    }
}


