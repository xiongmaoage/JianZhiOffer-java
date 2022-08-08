package jianzhiOffer;

// 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
// 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
// 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

// 错误；注意初始条件，要求至少两段与当前最大值冲突
public class Offer14 {
    public int cuttingRope(int n) {
        if (n < 2 || n > 58) {
            return -1;
        }
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int[] ropeLen = new int[n + 1];
        ropeLen[0] = 0;
        ropeLen[1] = 1;
        ropeLen[2] = 2;
        ropeLen[3] = 3;
        for (int len = 4; len <= n; len++) {
            int max = 0;
            for (int i = 1; i <= len / 2; i++) {
                max = Math.max(max, ropeLen[i] * ropeLen[len - i]);
            }
            ropeLen[len] = max;
        }
        return ropeLen[n];
    }
}
