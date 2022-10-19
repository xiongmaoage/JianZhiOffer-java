package codeTop;

import utils.TreeNode;

public class T098 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBST(root, (long)Integer.MIN_VALUE - 1 , (long)Integer.MAX_VALUE + 1);
    }

    private boolean isBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        int value = node.val;
        if (value <= min || value >= max) {
            return false;
        }
        return isBST(node.left, min, value) && isBST(node.right, value, max);

    }
}
