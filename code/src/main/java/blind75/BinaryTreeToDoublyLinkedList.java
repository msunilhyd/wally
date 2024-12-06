package blind75;

import com.sunil.TreeNode;

public class BinaryTreeToDoublyLinkedList {

    private static TreeNode head = null;
    private static TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode root = Util.getTree();
        convertToDLL(root);
        print(head);
    }

    // helper function to convert binary tree to doubly linked list
    private static void convertToDLL(TreeNode root) {
        if (root == null)
            return;

        // Recursively convert the left subtree
        convertToDLL(root.left);

        // if prev is null it means that this is the head of the DLL
        if (prev == null) {
            head = root;
        } else {
            // Link the previous node to the current root
            root.left = prev;
            prev.right = root;
        }
        // update prev to the current node
        prev = root;
        // Recursively convert the right subtree
        convertToDLL(root.right);
    }

    private static void print(TreeNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }
}
