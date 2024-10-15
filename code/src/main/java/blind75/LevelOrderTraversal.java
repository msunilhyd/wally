package blind75;

import com.sunil.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = Util.getTree();
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null)
            return ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i=0; i<len; i++) {
                TreeNode treeNode = queue.poll();
                System.out.print(treeNode.data + " " );
                if (treeNode.left != null)
                    queue.add(treeNode.left);
                if (treeNode.right != null)
                    queue.add(treeNode.right);
            }
            System.out.println();
        }
    }
}
