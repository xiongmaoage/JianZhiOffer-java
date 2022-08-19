package jianzhiOffer;

import utils.TreeNode;

// 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树

public class Offer55_2 {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) >= 0;
    }

    // 获得以该结点为根节点的平衡二叉树的深度。如果该树不是二叉树，则返回 -1
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int dist = left > right ? left - right : right - left;
        if (left < 0 || right < 0 || dist > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
