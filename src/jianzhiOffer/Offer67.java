package jianzhiOffer;

// 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。

// 使用while遍历数组时，随时警惕越界问题
public class Offer67 {
    public int strToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        long ans = 0;
        boolean isPositive = true;
        int index = 0;
        // 删除前摇空白字符
        while (index < str.length() && Character.isSpaceChar(str.charAt(index))) {
            index++;
        }
        if (index == str.length()) {
            return 0;
        }
        // 查看第一个字符，同时判断字符大小
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            isPositive = false;
            index++;
        } else if (!Character.isDigit(str.charAt(index))) {
            return 0;
        }
        if (index == str.length()) {
            return 0;
        }
        // 计算数值大小
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            ans = 10 * ans + str.charAt(index) - '0';
            if (ans > Integer.MAX_VALUE) {
                if (isPositive) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            index++;
        }
        if (!isPositive) {
            ans = -ans;
        }
        return (int)ans;
    }
}
