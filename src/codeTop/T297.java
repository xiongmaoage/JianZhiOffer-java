package codeTop;

import utils.TreeNode;

public class T297 {
    String serializedTree;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializedTree = "";
        serialTraverse(root);
        return serializedTree;
    }

    private void serialTraverse(TreeNode node) {
        save(node);
        if (node == null) {
            return;
        }
        serialTraverse(node.left);
        serialTraverse(node.right);
    }

    private void save(TreeNode node) {
        if (serializedTree.length() == 0) {
            serializedTree = "";
        } else {
            serializedTree += " ";
        }
        if (node == null) {
            serializedTree += "$";
        } else {
            serializedTree += node.val;
        }
    }

    String[] nodes;
    int arrayIndex;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       nodes = data.split(" ");
       arrayIndex = 0;
       TreeNode root = getNextNode();
       deSerialTraverse(root);
       return root;
    }

    // 给node放置左右孩子
    private void deSerialTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        node.left = getNextNode();
        deSerialTraverse(node.left);
        node.right = getNextNode();
        deSerialTraverse(node.right);
    }

    private TreeNode getNextNode() {
        if (arrayIndex < 0 || arrayIndex >= nodes.length) {
            System.out.println("error!");
            return null;
        }
        if ("$".equals(nodes[arrayIndex])) {
            arrayIndex++;
            return null;
        } else {
            int val = Integer.parseInt(nodes[arrayIndex]);
            arrayIndex++;
            return new TreeNode(val);
        }
    }
}
