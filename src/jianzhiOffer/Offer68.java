package jianzhiOffer;

import utils.TreeNode;

// 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

public class Offer68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);
        int rootValue = root.val;
        if (rootValue > large) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (rootValue < small) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
