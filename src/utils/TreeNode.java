package utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
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
    TreeNode(Integer[] input) {
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
 }