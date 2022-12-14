package jianzhiOffer;

// 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）
// 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角
// 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？


public class Offer47 {
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols];
        for (int[] ints : grid) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    dp[0] += ints[0];
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]) + ints[j];
                }
            }
        }
        return dp[cols - 1];
    }
}
