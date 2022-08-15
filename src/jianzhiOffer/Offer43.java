package jianzhiOffer;

// 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

// 注意234-1234中千位是1的有235个（1000也是）
// 注意计算后面其他位是1的时候，不需要管不是1的位置是不是1
public class Offer43 {
    // 每次降低一位，来递归计算其1的数量，以1234举例
    public int countDigitOne(int n) {
        String n_str = Integer.toString(n);
        int len = n_str.length();
        // 如果只有1位
        if (len == 1) {
            if (n == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        // 如果有多位
        // 最高位的1的数量
        int first;
        // 如果最高位是1，则统计234-1234中千位是1的个数，就是235个
        if (n_str.charAt(0) == '1') {
            first = n - (int)Math.pow(10, len - 1) + 1;
        }
        // 如果首位不是1，则统计345-2345中千位是1的个数，有1000-1999这1000个
        else {
            first = (int)Math.pow(10, len - 1);
        }
        // 其他位置的1，通过排列组合原则，第一位a有a种选择，剩下的len-1位中，有1位是1，其他len - 2位可以是任何数字
        int other = (n_str.charAt(0) - '0') * (len - 1) * (int)Math.pow(10, len - 2);
        return first + other + countDigitOne(n % (int)Math.pow(10, len - 1));
    }
}
