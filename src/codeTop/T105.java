package codeTop;

import utils.TreeNode;

public class T105 {
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree(0, 0, inorder.length);
    }

    private TreeNode buildTree(int preStart, int inStart, int len) {
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int splitIndex = inStart;
        while (inorder[splitIndex] != root.val) {
            splitIndex++;
        }
        int leftLen = splitIndex - inStart;
        root.left = buildTree(preStart + 1, inStart, leftLen);
        root.right = buildTree(preStart + leftLen + 1, inStart + leftLen + 1, len - leftLen - 1);
        return root;
    }
}
