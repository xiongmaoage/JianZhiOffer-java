package jianzhiOffer;

// 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
// 等等。

// 请写一个函数，求任意第n位对应的数字。
// 注意大数的越界问题
public class Offer44 {
    public int findNthDigit(int n) {
        if (n < 0) {
            return -1;
        }
        int remain = n;
        int digit = 1;
        // 获得最终数对应的位数以及剩余的位数
        while (remain > 0) {
            if (remain <= countNumByDigitNumber(digit)) {
                break;
            }
            remain -= countNumByDigitNumber(digit);
            digit++;
        }
        // 根据剩余的位数计算最终对应的数以及从左往右数的位数
        int number = (int)Math.pow(10, digit - 1) + remain / digit;
        int digitRemain = remain % digit;
        if (digitRemain == 0) { // 如果正好整除，则应该是上一个数的最后一位数
            number--;
            digitRemain = digit;
        }
        // 获取number从左往右数第digitRemain位数
        return Integer.toString(number).charAt(digitRemain - 1) - '0';
    }

    // 考虑越界问题
    // 计算digit位数共占几位。例如：3位数共占900*3=2700位
    private long countNumByDigitNumber(int digit) {
        // 一共有多少个数
        long nums = 9 * (long)Math.pow(10, digit - 1);
        // 每个数都有digit位
        return nums * digit;
    }
}
