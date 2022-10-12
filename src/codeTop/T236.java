package codeTop;

import utils.TreeNode;

import java.util.List;

// 左孩子和右孩子分别都有p、q中的一个即可
public class T236 {
    private TreeNode ans;
    private TreeNode p;
    private TreeNode q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        this.p = p;
        this.q = q;
        hasTarget(root);
        return ans;
    }

    // 检查以当前结点为根节点的子树是否存在p或q，如果存在返回true，不存在返回false
    // 特别的，如果该节点两个子树分别含有一个target（或者有一个是本身），则置ans
    private boolean hasTarget(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean leftSonHasTarget = hasTarget(node.left);
        boolean rightSonHasTarget = hasTarget(node.right);
        if (leftSonHasTarget && rightSonHasTarget) {
            ans = node;
        }
        if ((leftSonHasTarget || rightSonHasTarget) && (node == p || node == q)) {
            ans = node;
        }
        return leftSonHasTarget || rightSonHasTarget ||node == p || node == q;
    }
}
