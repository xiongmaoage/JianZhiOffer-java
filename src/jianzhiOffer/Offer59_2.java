package jianzhiOffer;

// 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
//
//若队列为空，pop_front 和 max_value需要返回 -1

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Offer59_2 {
}

class MaxQueue {
    // 记录数据用的queue
    Queue<Integer> queue;
    // 记录可能的最大值的数组deque
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    // 返回deque的第一个值
    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    // 将元素添加到queue中，同时检查deque，将队尾比当前元素小的内容出列
    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    // 删除队首元素。如果该元素正好也是deque的第一个元素，同步删除deque的元素
    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int element = queue.poll();
        if (!deque.isEmpty() && deque.peekFirst() == element) {
            deque.pollFirst();
        }
        return element;
    }
}
