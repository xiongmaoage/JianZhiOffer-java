package jianzhiOffer;

// 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”
// 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

// 注意审题，"06"不能转换
public class Offer46 {
    private String str;

    public int translateNum(int num) {
        str = Integer.toString(num);
        int len = str.length();
        int now = 1;
        int last = 0;
        for (int i = 0; i < len; i++) {
            int current;
            if (isAlpha(i)) {
                current = now + last;
            } else {
                current = now;
            }
            last = now;
            now = current;
        }
        return now;
    }

    // 判断index - 1和index这两个数是否小于26
    private boolean isAlpha(int index) {
        if (index <= 0) {
            return false;
        }
        if (str.charAt(index - 1) == '0') {
            return false;
        }
        int number = 10 * (str.charAt(index - 1) - '0') + str.charAt(index) - '0';
        return number < 26;
    }
}
