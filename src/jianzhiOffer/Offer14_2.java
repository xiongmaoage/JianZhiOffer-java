package jianzhiOffer;

// 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
// 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
// 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

// 数学题
// 重要！有关取模1e9+7等操作，用Long表示，最后返回的时候再修改为int，防止越界！
public class Offer14_2 {
    private final int mod = 1000000007;

    public int cuttingRope(int n) {
        if (n < 2 || n > 1000) {
            return -1;
        }
        if (n < 4) {
            return n - 1;
        }
        if (n % 3 == 0) {
            return (int)cutIn3(n);
        } else if (n % 3 == 1) {
            return (int)(cutIn3(n - 4) * 4 % mod);
        } else {
            return (int)(cutIn3(n - 2) * 2 % mod);
        }
    }

    private long cutIn3(int n) {
        if (n % 3 != 0) {
            return -1;
        }
        long ans = 1;
        while (n > 0) {
            ans = 3 * ans % mod;
            n -= 3;
        }
        return ans;

    }
}
