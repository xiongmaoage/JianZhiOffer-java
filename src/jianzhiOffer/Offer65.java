package jianzhiOffer;

// 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

// 不能使用循环，所以需要一下计算出所有的进位和 和 非进位和
// 即计算时先不考虑进位，让进位的数凑成一个新数。当再无进位时可以停止
public class Offer65 {
    public int add(int a, int b) {
        int sum_current = a;
        int sum_jinWei = b;
        while (sum_jinWei != 0) {
            // 计算这一轮相加中的新进位，新的进位要进位到左一位
            int new_jinWei = (sum_current & sum_jinWei) << 1;
            // 计算两个数的和
            sum_current = sum_current ^ sum_jinWei;
            // 更新进位和
            sum_jinWei = new_jinWei;
        }
        return sum_current;
    }
}
