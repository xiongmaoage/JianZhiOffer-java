package jianzhiOffer;

import java.util.PriorityQueue;

// 获取数据流中的中位数
public class Offer41 {
}


class MedianFinder {
    // 存较小的半部分，是一个大顶堆
    private PriorityQueue<Integer> smallHalf;
    // 存较大的半部分，是一个小顶堆
    private PriorityQueue<Integer> largeHalf;


    // 利用优先队列，维护一个最小堆和一个最大堆，将较小的一半数字放入最大堆，较大的一半数字放入最小堆
    public MedianFinder() {
        // 大顶堆
        smallHalf = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 小顶堆
        largeHalf = new PriorityQueue<>();
    }

    // 添加一个元素，保证smallHalf的大小和largeHalf一样，或者比largeHalf多一个
    public void addNum(int num) {
        // 如果两个堆一样大，则比较其与largeHalf的最小值的关系，根据情况加入smallHalf
        if (smallHalf.size() == largeHalf.size()) {
            // 如果两个堆都是空的或者加入的数比较小，则直接加入smallHalf，否则将largeHalf的最小值加入smallHalf
            if (largeHalf.isEmpty() || num <= largeHalf.peek()) {
                smallHalf.add(num);
            } else {
                largeHalf.add(num);
                smallHalf.add(largeHalf.poll());
            }
        }
        // 如果smallHalf比largeHalf多一个，则对比smallHalf的最大值，来决定如何加入largeHalf
        if (smallHalf.size() > largeHalf.size()) {
            if (smallHalf.peek() > num) {
                smallHalf.add(num);
                largeHalf.add(smallHalf.poll());
            } else {
                largeHalf.add(num);
            }
        }
    }

    public double findMedian() {
        if (smallHalf.isEmpty()) {
            System.out.println("null");
            return 0;
        }
        // 如果两个堆一样大，则返回中间值的平均数，否则返回smallHalf的最大值
        if (smallHalf.size() == largeHalf.size()) {
            return ((double) smallHalf.peek() + largeHalf.peek()) / 2;
        } else {
            return (double)smallHalf.peek();
        }

    }
}
