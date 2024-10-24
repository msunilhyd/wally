package blind75;

import com.sunil.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Util {

    public static TreeNode getTree() {

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(7);

        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(8);

        right.left = rightLeft;
        right.right = rightRight;

        root.left = left;
        root.right = right;
        return root;
    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            System.out.println();
        }
    }

    public static ListNode getList() {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        return one;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
}
