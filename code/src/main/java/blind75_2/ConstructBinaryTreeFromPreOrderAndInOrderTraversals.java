package blind75_2;

import blind75.Util;
import com.sunil.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreOrderAndInOrderTraversals {

    private static int[] preOrder;
    private static int[] inOrder;
    private static Map<Integer, Integer> inOrderMap = new HashMap();

    public static void main(String[] args) {
        preOrder = new int[] {3, 9, 20, 15, 7};
        inOrder = new int[] {9, 3, 15, 20, 7};
        for (int i=0; i<inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        Util.printTree(recurse(0, preOrder.length - 1, 0, inOrder.length - 1 ));
    }

    private static TreeNode recurse(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        int inIndex = inOrderMap.get(preOrder[preStart]);
        int nLeft = inIndex - inStart;
        TreeNode root = new TreeNode(preOrder[preStart]);
        root.left = recurse(preStart + 1, preStart + nLeft, inStart, inIndex - 1);
        root.right = recurse(preStart + nLeft + 1, preEnd, inIndex + 1, inEnd);
        return root;
    }
}
