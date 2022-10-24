package codeTop;

public class T152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        } else if (len == 1) {
            return nums[0];
        }
        // 动态规划数组，dp[i]代表以i为结尾的绝对值最大乘积的值，其中0为正数，1为负数
        int[][] dp = new int[len][2];
        // 初始条件，其中如果没有最小负数，则置为0即可
        if (nums[0] >= 0) {
            dp[0][0] = nums[0];
            dp[0][1] = 0;
        } else {
            dp[0][0] = 0;
            dp[0][1] = nums[0];
        }
        int max = dp[0][0];
        for (int i = 1; i < len; i++) {
            // 分奇偶讨论。这里的max是因为如果前面是0，则取当前值
            if (nums[i] >= 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = dp[i - 1][1] * nums[i];
            } else {
                dp[i][0] = dp[i - 1][1] * nums[i];
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
            }
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}
