package jianzhiOffer;

import utils.TreeNode;

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
//假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

public class Offer07 {
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return buildCore(0, length, 0, length);
    }

    private TreeNode buildCore(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart == preEnd || inStart == inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = findInOrder(preorder[preStart]);
        int leftLength = rootIndex - inStart;
        root.left = buildCore(preStart + 1, preStart + 1 + leftLength, inStart, rootIndex);
        root.right = buildCore(preStart + 1 + leftLength, preEnd, rootIndex + 1, inEnd);
        return root;
    }

    private int findInOrder(int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
