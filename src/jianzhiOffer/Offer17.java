package jianzhiOffer;

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
public class Offer17 {
    public int[] printNumbers(int n) {
        int len = (int)Math.pow(10, n);
        int[] ans = new int[len - 1];
        for (int i = 1; i < len; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }
}
