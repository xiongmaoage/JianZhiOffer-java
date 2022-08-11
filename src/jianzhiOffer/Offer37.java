package jianzhiOffer;

import utils.TreeNode;

// 请实现两个函数，分别用来序列化和反序列化二叉树。
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

// 使用前序遍历（这样可以先确定根节点），空节点使用$填充，使用' '分隔
public class Offer37 {
    private String[] nodes;
    private int nodeIndex;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer string = new StringBuffer("{");
        visit(root, string);
        string.append("}");
        return string.toString();
    }

    private void visit(TreeNode node,StringBuffer string) {
        addNode2String(node, string);
        if (node == null) {
            return;
        }
        visit(node.left, string);
        visit(node.right, string);
    }

    private void addNode2String(TreeNode node, StringBuffer string) {
        if (string == null) {
            return;
        }
        if (node == null) {
            string.append(" $");
        } else {
            string.append(' ');
            string.append(node.val);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.nodes = data.substring(2, data.length() - 1).split(" ");
        this.nodeIndex = 0;
        return build();
    }

    private TreeNode build() {
        if (nodeIndex >= nodes.length) {
            return null;
        }
        String nodeVal = nodes[nodeIndex];
        nodeIndex++;
        if (nodeVal.equals("$")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
        node.left = build();
        node.right = build();
        return node;
    }
}
