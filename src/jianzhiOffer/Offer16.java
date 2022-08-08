package jianzhiOffer;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。

// 需要使用快速幂
// 右移没有除以2稳
public class Offer16 {
    public double myPow(double x, int n) {
        if (x <= -100 || x >= 100) {
            return 0;
        }
        // 0的任何次幂都为0，1的任何次幂都为1
        if (x == 0 || x == 1) {
            return x;
        }
        if (n >= 0) {
            return myPowPositive(x, n);
        } else {
            return 1 / myPowPositive(x, -n);
        }
    }

    private double myPowPositive(double x, int n) {
        // 任何数的0次幂是1（0^0暂不考虑）
        if (n == 0) {
            return 1;
        }
        double half = myPowPositive(x, n >> 1);
        double ans = half * half;
        if ((n & 1) != 0) {
            ans *= x;
        }
        return ans;

    }
}
