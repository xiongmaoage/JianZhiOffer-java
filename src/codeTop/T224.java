package codeTop;

import java.util.Stack;

public class T224 {
    public int calculate(String s) {
        // 去掉所有空格
        s = s.replaceAll(" ", "");
        // 如果 s 的第一个字符是'-'，则在前面补0，将所有的+和-当做二元运算符，且所有的操作数均为非负整数
        if (s.charAt(0) == '-') {
            s = '0' + s;
        }
        // 使用一个运算符栈和一个操作数栈，将对应的内容入栈
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果当前字符是数字，则一直读完当前的数字，并看运算栈的情况是否加入
            if (Character.isDigit(c)) {
                // 获取当前数字
                int number = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    number *= 10;
                    number += s.charAt(i) - '0';
                    i++;
                }
                i--;        // 为了循环调整i的值，方便循环后的i++
                // 查看操作符栈的栈顶元素，如果是+-，则弹出两个栈顶元素，合成新的元素。如果栈顶元素是(，则加入操作数栈
                if (operators.isEmpty() || operators.peek() == '(') {
                    numbers.push(number);
                } else {
                    int n1 = numbers.pop();
                    char operator = operators.pop();
                    if (operator == '+') {
                        numbers.push(n1 + number);
                    } else {
                        numbers.push(n1 - number);
                    }
                }
            }
            // 如果是操作符，则根据操作符的内容分类讨论
            else {
                if (c == '+' || c == '-' || c == '(') {
                    operators.push(c);
                    // 如果当前符号是(且下一个符号是-，需要在符号栈中补0
                    if (c == '(' && s.charAt(i + 1) == '-') {
                        numbers.push(0);
                    }
                } else if (c == ')') {
                    // 弹出栈顶的(，并且如果弹出后栈顶元素不是（，则将运算栈的两个栈顶元素进行运算并重新压栈
                    operators.pop();
                    if (!operators.isEmpty() && operators.peek() != '(') {
                        int n2 = numbers.pop();
                        int n1 = numbers.pop();
                        if (operators.pop() == '+') {
                            numbers.push(n1 + n2);
                        } else {
                            numbers.push(n1 - n2);
                        }
                    }
                }
            }
        }
        return numbers.pop();
    }
}
