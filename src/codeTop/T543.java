package codeTop;

import utils.TreeNode;

public class T543 {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = -1;
        getDepth(root);
        return max;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
