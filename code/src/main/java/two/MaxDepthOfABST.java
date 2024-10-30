package two;

import blind75.Util;
import com.sunil.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfABST {

    public static void main(String[] args) {
        System.out.println(find(Util.getTree()));
    }

    public static int find(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxHeight = 0;
        while (!queue.isEmpty()) {
            maxHeight++;
            for (int i=0; i<queue.size(); i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return maxHeight;
    }
}
