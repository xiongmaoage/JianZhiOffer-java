package utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 通过整形数组，使用层次遍历初始化树
    public TreeNode(Integer[] input) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode();
        queue.offer(root);
        for (Integer i:input) {
            if (i == null) {
                queue.poll();
                continue;
            }
            TreeNode treeNode = new TreeNode(i);
            if (!queue.isEmpty()) {
                TreeNode father = queue.poll();
                TreeNode next = queue.peek();
                if (next != null && next.equals(father)) {
                    father.left = treeNode;
                } else {
                    father.right = treeNode;
                }
            }
            queue.offer(treeNode);
            queue.offer(treeNode);
        }
        this.left = root.right.left;
        this.right = root.right.right;
        this.val = root.right.val;
    }

    @Override
    public String toString() {
        StringBuffer string = new StringBuffer("{");
        visit(this, string);
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


    private String[] nodes;
    private int nodeIndex;

    // 将前序字符串转换为一棵树
    public TreeNode preOrder2Tree(String data) {
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