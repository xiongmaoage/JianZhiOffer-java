package codeTop;

import utils.TreeNode;

public class T222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int layers = 0;
        TreeNode node = root;
        while (node != null) {
            node = node.left;
            layers++;
        }
        // 第layer层共有2^(layer - 1)个结点，在这个范围内二分查找
        double nodes = 1 << layers - 1;
        int left = 1, right = (int)nodes - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (exist(root, mid, layers)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        double nodesInFrontLayers = nodes - 1;
        return (int)nodesInFrontLayers + left;
    }

    private boolean exist(TreeNode root, int number, int layer) {
        int mask = 1 << layer - 2;
        TreeNode node = root;
        while (mask != 0) {
            node = (number & mask) == 0 ? node.left : node.right;
            mask >>= 1;

        }
        return node != null;
    }
}
