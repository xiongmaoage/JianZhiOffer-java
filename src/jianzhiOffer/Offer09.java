package jianzhiOffer;

// 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

import java.util.Stack;

public class Offer09 {
}

class CQueue {
    private final Stack<Integer> in = new Stack<>();
    private final Stack<Integer> out = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            return -1;
        }
        return out.pop();
    }
}

