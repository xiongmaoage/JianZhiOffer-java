package jianzhiOffer;

import utils.TreeNode;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//B是A的子结构， 即 A中有出现和B相同的结构和节点值。

//注意每一个函数（尤其是递归函数）的判空问题

public class Offer26 {
    private boolean ans = false;
    private TreeNode subTree;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        subTree = B;
        this.recurse(A);
        return ans;
    }

    private void recurse(TreeNode node) {
        if (node == null) {
            return;
        }
        if (isSameTree(node, subTree)) {
            ans = true;
            return;
        }
        recurse(node.left);
        if (ans) return;
        recurse(node.right);
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        if (node2.left != null && !isSameTree(node1.left, node2.left)) {
            return false;
        }
        if (node2.right != null && !isSameTree(node1.right, node2.right)) {
            return false;
        }
        return true;
    }
}
