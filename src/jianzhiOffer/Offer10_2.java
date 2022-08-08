package jianzhiOffer;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
public class Offer10_2 {
    public int numWays(int n) {
        if (n < 0 || n > 100) {
            return -1;
        }
        if (n < 2) {
            return 1;
        }
        int past = 1;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int mod = 1000000007;
            int temp = (past + current) % mod;
            past = current;
            current = temp;
        }
        return current;
    }
}
