package jianzhiOffer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer34 {
    private List<Integer> path;
    private int target;
    private List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        this.path = new ArrayList<>();
        this.target = target;
        this.ans = new ArrayList<>();

        visit(root);
        return ans;
    }

    private void visit(TreeNode node) {
        path.add(node.val);
        if (isLeaf(node)) {
            if (getPathSum() == target) {
                List<Integer> copyList = new ArrayList<>();
                copyList.addAll(path);
                ans.add(copyList);
            }
        }
        if (node.left != null) {
            visit(node.left);
        }
        if (node.right != null) {
            visit(node.right);
        }
        path.remove(path.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private int getPathSum() {
        int sum = 0;
        for (Integer val : path) {
            sum += val;
        }
        return sum;
    }
}

