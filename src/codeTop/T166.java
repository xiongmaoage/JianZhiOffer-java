package codeTop;

import java.util.HashMap;
import java.util.Map;

public class T166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        boolean isPositive = true;
        long dividend = numerator;
        long divided = denominator;
        if (dividend < 0) {
            isPositive = false;
            dividend = -dividend;
        }
        if (divided < 0) {
            isPositive = !isPositive;
            divided = -divided;
        }
        StringBuilder ans = new StringBuilder();
        if (!isPositive) {
            ans.append('-');
        }
        ans.append(dividend / divided);
        long remain = dividend % divided;
        if (remain == 0) {
            return ans.toString();
        }
        ans.append('.');
        int numLen = ans.length();
        Map<Long, Integer> remain2Index = new HashMap<>();
        while (remain != 0 && numLen < 10005) {
            if (remain2Index.containsKey(remain)) {
                // 找到了循环节，来处理括号
                int index = remain2Index.get(remain);
                ans.insert(index, '(').append(')');
                break;
            }
            remain2Index.put(remain, numLen);
            remain *= 10;
            ans.append(remain / divided);
            remain %= divided;
            numLen++;
        }
        return ans.toString();
    }
}
