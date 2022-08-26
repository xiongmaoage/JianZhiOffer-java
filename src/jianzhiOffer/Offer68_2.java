package jianzhiOffer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

public class Offer68_2 {
    private List<TreeNode> path;
    private TreeNode[] path1;
    private TreeNode[] path2;
    private TreeNode target1;
    private TreeNode target2;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        path = new ArrayList<>();
        target1 = p;
        target2 = q;
        findPath(root);
        int index = 0;
        while (index < path1.length && index < path2.length && path1[index].equals(path2[index])) {
            index++;
        }
        return path1[index - 1];
    }

    private void findPath(TreeNode node) {
        if (node == null) {
            return;
        }
        path.add(node);
        if (node.val == target1.val) {
            path1 = genPathArray();
        }
        if (node.val == target2.val) {
            path2 = genPathArray();
        }
        findPath(node.left);
        findPath(node.right);
        path.remove(node);
    }

    private TreeNode[] genPathArray() {
        int len = path.size();
        TreeNode[] ans = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            ans[i] = path.get(i);
        }
        return ans;
    }
}
