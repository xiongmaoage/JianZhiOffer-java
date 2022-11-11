package codeTop;

import java.util.Arrays;

public class T096 {
    private int[] nums;

    // 由n个结点组成的二叉搜索树的个数
    public int numTrees(int n) {
        nums = new int[n + 1];
        Arrays.fill(nums, 0);
        nums[0] = 1;
        nums[1] = 1;
        return myNumTrees(n);
    }

    private int myNumTrees(int n) {
        if (nums[n] != 0) {
            return nums[n];
        }
        int ans = 0;
        // 选择根节点root，则左子树的数量为root - 1，右节点的数量为n-root
        for (int root = 1; root <= n; root++) {
            int left = myNumTrees(root - 1);
            int right = myNumTrees(n - root);
            ans += left * right;
        }
        nums[n] = ans;
        return ans;
    }

    // 计算组合数：从n个结点里面选择m个结点的个数
    private int combinatorialNumber(int n, int m) {
        long ans = 1;
        if (m > n / 2) {
            m = n - m;
        }
        for (int i = n; i >= n - m + 1; i--) {
            ans *= i;
        }
        for (int i = 1; i <= m; i++) {
            ans /= i;
        }
        return (int)ans;
    }
}
