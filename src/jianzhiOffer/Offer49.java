package jianzhiOffer;

// 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）
// 求按从小到大的顺序的第 n 个丑数。

// 灵活计算下一个丑数，具体方法为使用指针记录下一个可能的情况的位置
public class Offer49 {
    private int[] uglyNumberList;
    int index2 = 0;
    int index3 = 0;
    int index5 = 0;

    public int nthUglyNumber(int n) {
        uglyNumberList = new int[n];
        uglyNumberList[0] = 1;
        for (int i = 1; i < n; i++) {
            uglyNumberList[i] = getNextUglyNumber(i);
        }
        return uglyNumberList[n - 1];
    }

    private int getNextUglyNumber(int index) {
        int number = Math.min(2 * uglyNumberList[index2],
                Math.min(3 * uglyNumberList[index3], 5 * uglyNumberList[index5]));
        updatePointers(number, index);
        return number;
    }

    private void updatePointers(int number, int index) {
        while (index2 < index && 2 * uglyNumberList[index2] <= number) {
            index2++;
        }
        while (index3 < index && 3 * uglyNumberList[index3] <= number) {
            index3++;
        }
        while (index5 < index && 5 * uglyNumberList[index5] <= number) {
            index5++;
        }
    }
}
