package codeTop;

public class T123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // dp[i]代表前i个元素中投资能得到的最大值，其中
        // dp[i][0]代表已经买进一次
        // dp[i][1]代表已经买进卖出一次
        // dp[i][2]代表已经完成一次交易之后又买进一次
        // dp[i][3]代表完成全部交易
        int[][] dp = new int[len][];
        int minInt = -10005;
        dp[0] = new int[]{-prices[0], minInt, minInt, minInt};
        for (int i = 1; i < len; i++) {
            int[] current = new int[4];
            current[0] = Math.max(dp[i - 1][0], -prices[i]);
            current[1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            current[2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            current[3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
            dp[i] = current;
        }
        return Math.max(Math.max(dp[len - 1][1], dp[len - 1][3]), 0);
    }
}
