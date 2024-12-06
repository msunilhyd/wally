package blind75;

import com.sunil.TreeNode;

public class ConstructBinaryTreeFromPreOrderInOrderTraversals {

    public static int[] preOrder;
    private static int[] inOrder;

    public static void main(String[] args) {
        preOrder = new int[]{3, 9, 20, 15, 7};
        inOrder = new int[] {9, 3, 15, 20, 7};
        Util.printTree(find(preOrder, inOrder));
    }

    public static TreeNode find(int[] preOrder, int[] inOrder) {
        return recurse(0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    public static TreeNode recurse(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        int rootVal = preOrder[preStart];
        int inIndex = getIndex(rootVal, inOrder);
        int nLeft = inIndex - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = recurse(preStart + 1, preStart + nLeft, inStart, inIndex - 1);
        root.right = recurse(preStart + 1 + nLeft, preEnd, inIndex + 1, inEnd);

        return root;
    }

    private static int getIndex(int val, int[] arr) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }
}
