package codeTop;

import java.util.LinkedList;
import java.util.List;

public class T679 {
    private List<Double> numbers;
    static private final double EPSILON = 1e-6;
    private boolean ans;

    public boolean judgePoint24(int[] cards) {
        numbers = new LinkedList<>();
        ans = false;
        for (int i = 0; i < 4; i++) {
            numbers.add((double)cards[i]);
        }
        calculate();
        return ans;
    }

    // 从numbers中选择两个数分别进行四则运算，将运算结果放回到numbers中
    private void calculate() {
        // 如果已经找到了，直接返回
        if (ans) {
            return;
        }
        int len = numbers.size();
        // 如果长度为1，则判断该数是否是24，允许有误差
        if (len == 1) {
            ans = equalDouble(numbers.get(0), 24);
            return;
        }
        for (int i1 = 0; i1 < len - 1; i1++) {
            double number1 = numbers.get(i1);
            for (int i2 = i1 + 1; i2 < len; i2++) {
                double number2 = numbers.get(i2);
                // 从numbers中删除这两个数
                numbers.remove(number1);
                numbers.remove(number2);
                // 求和
                numbers.add(number1 + number2);
                calculate();
                numbers.remove(number1 + number2);
                // 求差
                if (equalDouble(number1, number2)) {
                    numbers.add((double)0);
                    calculate();
                    numbers.remove((double)0);
                } else {
                    numbers.add(number1 - number2);
                    calculate();
                    numbers.remove(number1 - number2);
                    numbers.add(number2 - number1);
                    calculate();
                    numbers.remove(number2 - number1);
                }
                // 求积
                numbers.add(number1 * number2);
                calculate();
                numbers.remove(number1 * number2);
                // 求商（注意除零异常）
                if (equalDouble(number1, number2) && !equalDouble(number1, 0)) {
                    numbers.add((double)1);
                    calculate();
                    numbers.remove((double)1);
                } else {
                    if (!equalDouble(number2, 0)) {
                        numbers.add(number1 / number2);
                        calculate();
                        numbers.remove(number1 / number2);
                    }
                    if (!equalDouble(number1, 0)) {
                        numbers.add(number2 / number1);
                        calculate();
                        numbers.remove(number2 / number1);
                    }
                }
                // 恢复这两个数，以便继续回溯
                numbers.add(i1, number1);
                numbers.add(i2, number2);
            }
        }
    }

    private boolean equalDouble(double m, double n) {
        return Math.abs(m - n) < EPSILON;
    }
}
