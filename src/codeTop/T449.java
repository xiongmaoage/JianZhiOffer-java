package codeTop;

import utils.TreeNode;

public class T449 {
}

class Codec {

    // 生成后序遍历
    private StringBuilder postOrder;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        postOrder = new StringBuilder();
        genPostOrder(root);
        postOrder.deleteCharAt(postOrder.length() - 1);
        return postOrder.toString();
    }

    private void genPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        genPostOrder(node.left);
        genPostOrder(node.right);
        postOrder.append(node.val).append(" ");
    }

    // 根据后序遍历生成树
    private int[] numbers;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] strings = data.split(" ");
        numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        return buildTree(0, numbers.length);
    }

    private TreeNode buildTree(int start, int end) {
        if (start == end) {
            return null;
        }
        int rootValue = numbers[end - 1];
        TreeNode root = new TreeNode(rootValue);
        if (start == end - 1) {
            return root;
        }
        int splitPos = start;
        while (splitPos < end - 1) {
            if (numbers[splitPos] > rootValue) {
                break;
            }
            splitPos++;
        }
        root.left = buildTree(start, splitPos);
        root.right = buildTree(splitPos, end - 1);
        return root;
    }
}
