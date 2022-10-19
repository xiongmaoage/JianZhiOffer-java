package codeTop;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T094 {
    private List<Integer> ans;

    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        ans.add(node.val);
        dfs(node.right);
    }
}
