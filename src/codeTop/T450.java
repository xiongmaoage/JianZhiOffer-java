package codeTop;

import utils.TreeNode;

public class T450 {
    private int key;
    private TreeNode keyNode;
    private TreeNode keyFather;
    private boolean isLeftChild;
    private TreeNode newRoot;   // 新的根节点，用来方便扩充

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        this.key = key;
        this.keyNode = null;
        this.newRoot = new TreeNode();
        newRoot.right = root;
        // 找到目标节点
        findKeyNode(newRoot);
        // 如果没有找到，返回根节点
        if (keyNode == null) {
            return root;
        }
        // 如果目标节点没有右子树，则直接将左子树连接到父亲结点
        if (keyNode.right == null) {
            if (isLeftChild) {
                keyFather.left = keyNode.left;
            } else {
                keyFather.right = keyNode.left;
            }
            // 返回根节点
            return newRoot.right;
        }
        // 将目标节点的右子树连接到父亲结点
        if (isLeftChild) {
            keyFather.left = keyNode.right;
        } else {
            keyFather.right = keyNode.right;
        }
        // 将目标节点的左子树连接到目标节点右子树的最左节点
        TreeNode mostLeft = keyNode.right;
        while (mostLeft.left != null) {
            mostLeft = mostLeft.left;
        }
        mostLeft.left = keyNode.left;
        // 返回根节点
        return newRoot.right;
    }

    private void findKeyNode(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.left.val == key) {
            keyFather = node;
            keyNode = node.left;
            isLeftChild = true;
            return;
        }
        if (node.right != null && node.right.val == key) {
            keyFather = node;
            keyNode = node.right;
            isLeftChild = false;
            return;
        }
        findKeyNode(node.left);
        findKeyNode(node.right);
    }
}
