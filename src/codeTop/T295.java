package codeTop;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T295 {
}

class MedianFinder {
    // 数据流较小的半部分，是个大顶堆，返回较小部分的最大值，长度大于等于large
    private final PriorityQueue<Integer> small;
    // 数据流较大的半部分，是个小顶堆，返回较大部分的最小值，长度小于等于small
    private final PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Comparator.comparingInt(n -> -n));
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 如果两个尺寸相等，则加到small中，具体为加入large，然后把large最小的加入small
        if (small.size() == large.size()) {
            if (large.isEmpty() || num <= large.peek()) {
                small.offer(num);
            } else {
                large.offer(num);
                small.offer(large.poll());
            }
        } else {    // 如果small比large大，则将其加入到large，具体为将其加入small，然后把最大的加入large
            if (small.isEmpty()) {
                System.out.println("error");
                return;
            }
            if (num >= small.peek()) {
                large.offer(num);
            } else {
                small.offer(num);
                large.offer(small.poll());
            }
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return ((double)small.peek() + large.peek()) / 2;
        } else {
            return small.peek();
        }
    }
}
