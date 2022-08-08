package jianzhiOffer;

//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下
public class Offer10 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int current = 1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            int mod = 1000000007;
            int newCurrent = (last + current) % mod;
            last = current;
            current = newCurrent;
        }
        return current;
    }

}
