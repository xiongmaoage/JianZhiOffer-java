package codeTop;

import utils.TreeNode;

public class T110 {
    // 记录当前的树是否是平衡树
    private boolean ans;

    public boolean isBalanced(TreeNode root) {
        this.ans = true;
        getTreeDepth(root);
        return ans;
    }

    private int getTreeDepth(TreeNode node) {
        if (!ans) { return -1; }
        if (node == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(node.left);
        if (!ans) { return -1; }
        int rightDepth = getTreeDepth(node.right);
        if (!ans) { return -1; }
        int maxDepth = Math.max(leftDepth, rightDepth);
        int minDepth = Math.min(leftDepth, rightDepth);
        if (maxDepth - minDepth > 1) {
            ans = false;
            return -1;
        }
        return maxDepth + 1;
    }
}
