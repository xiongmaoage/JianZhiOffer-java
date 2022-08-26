package jianzhiOffer;

// 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。

public class Offer62 {
    public int lastRemaining(int n, int m) {
        return joseph(n, m);
    }

    // 递归解决约瑟夫问题的函数，n是总数，m是一次跨越几个数
    private int joseph(int n, int m) {
        // 如果只剩1个数了，则返回0（第0）
        if (n == 1) {
            return 0;
        }
        // 获取到删除了一个数之后，最后会剩下多少
        int x = joseph(n - 1, m);
        // 通过映射来还原，其中m是本轮删除的一个数，x是剩余的数的话，直接相加即可
        return (m + x) % n;
    }
}
