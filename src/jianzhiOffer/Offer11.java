package jianzhiOffer;

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

// 错误点：注意分治时超过数组界限的情况，注意最后剩下两个时候的临界情况
public class Offer11 {
    private int[] numbers;

    public int minArray(int[] numbers) {
        this.numbers = numbers;
        return findMinCore(0, numbers.length);

    }

    private int findMinCore(int start, int end) {
        if (start >= end) {
            return -1;
        }
        if (start + 1 == end) {
            return numbers[start];
        }
        if (start + 2 == end) {
            return Math.min(numbers[start], numbers[start + 1]);
        }
        if (numbers[start] < numbers[end - 1]) {
            return numbers[start];
        }
        int mid = (start + end) / 2;
        // 特殊情况，三个都相等可能其他地方存在最小值
        if (numbers[start] == numbers[mid] && numbers[mid] == numbers[end - 1]) {
            return findMinIterate(start, end);
        }
        if (numbers[start] > numbers[mid]) {
            return findMinCore(start, mid + 1);
        } else {
            return findMinCore(mid, end);
        }
    }

    private int findMinIterate(int start, int end) {
        if (start >= end) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            min = Math.min(min, numbers[i]);
        }
        return min;
    }

}
