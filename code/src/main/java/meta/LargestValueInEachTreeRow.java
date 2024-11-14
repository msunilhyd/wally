package meta;

import blind75.Util;
import com.sunil.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachTreeRow {

    public static void main(String[] args) {
        TreeNode root = Util.getTree();
        System.out.println(find(root));
    }

    public static List<Integer> find(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
           int size = queue.size();
           int max = Integer.MIN_VALUE;
           for (int i=0; i<size; i++) {
               TreeNode temp = queue.poll();
               max = Math.max(max, temp.data);
               if (temp.left != null)
                   queue.add(temp.left);
               if (temp.right != null)
                   queue.add(temp.right);
           }
          res.add(max);
        }
        return res;
    }
}
