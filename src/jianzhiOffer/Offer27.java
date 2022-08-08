package jianzhiOffer;

import utils.TreeNode;

//请完成一个函数，输入一个二叉树，该函数输出它的镜像。

public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        this.mirrorTreeRecursive(root);
        return root;
    }

    private void mirrorTreeRecursive(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirrorTreeRecursive(node.left);
        mirrorTreeRecursive(node.right);
    }
}
