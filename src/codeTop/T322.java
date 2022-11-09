package codeTop;

import java.util.Arrays;
import java.util.Comparator;

public class T322 {
    private int[] minCoin;
    int[] coins;
    int len;

    public int coinChange(int[] coins, int amount) {
        minCoin = new int[10005];
        Arrays.fill(minCoin, 0);
        this.coins = coins;
        len = coins.length;
        return search(amount);
    }

    private int search(int remain) {
        if (remain < 0) {
            return -1;
        }
        if (remain == 0) {
            return 0;
        }
        if (minCoin[remain] != 0) {
            return minCoin[remain];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int t = search(remain - coins[i]);
            if (t == -1) {
                continue;
            }
            min = Math.min(min, t);
        }
        int ans = min == Integer.MAX_VALUE ? -1 : (min + 1);
        minCoin[remain] = ans;
        return ans;
    }
}
