package codeTop;

public class T064 {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // 记录距离当前值一行以内的所有值
        int[] dp = new int[cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0) {
                    if (col == 0) {
                        dp[col] = grid[0][0];
                    } else {
                        dp[col] = dp[col - 1] + grid[0][col];
                    }
                } else {
                    if (col == 0) {
                        dp[col] += grid[row][0];
                    } else {
                        dp[col] = Math.min(dp[col - 1], dp[col]) + grid[row][col];
                    }
                }
            }
        }
        return dp[cols - 1];
    }
}
