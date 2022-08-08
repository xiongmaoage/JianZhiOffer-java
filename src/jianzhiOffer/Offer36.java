package jianzhiOffer;


public class Offer36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node max;
    private Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        this.convertRecursive(root);
        head.left = max;
        max.right = head;
        return head;
    }

    private void convertRecursive(Node root) {
        if (root == null) {
            return;
        }
        // 转换左子树
        convertRecursive(root.left);
        // 如果是一开始max为null时
        if (max == null) {
            head = root;
        } else {
            // 与左子树的最大节点相连
            max.right = root;
            root.left = max;
        }
        // 更新最大节点
        max = root;
        // 转换右子树
        convertRecursive(root.right);
    }
}
