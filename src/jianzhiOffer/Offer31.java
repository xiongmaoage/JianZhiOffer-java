package jianzhiOffer;

// 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序.假设压入栈的所有数字均不相等

// 注意，当循环结束有两个以上条件的时候，判断停止时有三种情况：不满足A，不满足B，和同时不满足AB
import java.util.Stack;

public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped.length != pushed.length) {
            return false;
        }
        int len = popped.length;

        Stack<Integer> stack = new Stack<>();
        int index = 0;  // pushed的下标
        for (int element : popped) {
            if (stack.isEmpty() && index < len) {
                stack.push(pushed[index]);
                index++;
            }
            while (stack.peek() != element && index < len) {
                stack.push(pushed[index]);
                index++;
            }
            if (index == len && stack.peek() != element) {
                return false;
            }
            stack.pop();
        }
        return true;
    }
}
