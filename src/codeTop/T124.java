package codeTop;

import utils.TreeNode;

import java.util.HashMap;

public class T124 {
    private HashMap<TreeNode, Integer> node2Sum;    // 保存以某个结点为根节点的最大路径和
    private int pathSum;

    public int maxPathSum(TreeNode root) {
        this.node2Sum = new HashMap<>();
        setNodeSum(root);
        pathSum = Integer.MIN_VALUE;
        findMaxNode(root);
        return pathSum;
    }

    // 保存以某个结点为根节点的最大路径和
    private void setNodeSum(TreeNode node) {
        if (node == null) {
            return;
        }
        // 分别统计左右子树的最大值
        int leftSum = 0, rightSum = 0;
        if (node.left != null) {
            setNodeSum(node.left);
            leftSum = Math.max(leftSum, node2Sum.get(node.left));
        }
        if (node.right != null) {
            setNodeSum(node.right);
            rightSum = Math.max(rightSum, node2Sum.get(node.right));
        }
        int sum = Math.max(leftSum, rightSum) + node.val;
        node2Sum.put(node, sum);
    }

    // 遍历每一个结点，查看以该结点为路径最高层结点的和
    private void findMaxNode(TreeNode node) {
        if (node == null) {
            return;
        }
        getNodeMaxSum(node);
        findMaxNode(node.left);
        findMaxNode(node.right);
    }

    // 获得以node为根节点的最大路径和并更新和的最大值
    private void getNodeMaxSum(TreeNode node) {
        if (node == null) {
            return;
        }
        // 获取当前节点的最大值
        int leftSum = 0, rightSum = 0;
        if (node.left != null) {
            leftSum = Math.max(leftSum, node2Sum.get(node.left));
        }
        if (node.right != null) {
            rightSum = Math.max(rightSum, node2Sum.get(node.right));
        }
        int maxSum = leftSum + rightSum + node.val;
        // 更新最大值
        pathSum = Math.max(pathSum, maxSum);
    }
}
