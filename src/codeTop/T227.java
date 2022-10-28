package codeTop;

import java.util.Stack;

public class T227 {
    public int calculate(String s) {
        String string = s.replaceAll(" ", "");
        Stack<Character> operators = new Stack<>();
        Stack<Long>  numbers = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isDigit(c)) {
                long number = 0;
                while (i < string.length() && Character.isDigit(string.charAt(i))) {
                    number *= 10;
                    number += string.charAt(i) - '0';
                    i++;
                }
                i--;
                if (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
                    long n1 = numbers.pop();
                    if (operators.pop() == '*') {
                        numbers.push(n1 * number);
                    } else {
                        numbers.push(n1 / number);
                    }
                } else {
                    numbers.push(number);
                }
            } else {
                if (c == '+' || c == '-') {
                    // 计算操作栈中的所有值
                    while (!operators.isEmpty()) {
                        char operator = operators.pop();
                        long n2 = numbers.pop();
                        long n1 = numbers.pop();
                        if (operator == '+') {
                            numbers.push(n1 + n2);
                        } else {
                            numbers.push(n1 - n2);
                        }
                    }
                    operators.add(c);
                } else {
                    operators.add(c);
                }
            }
        }
        if (!operators.isEmpty()) {
            char operator = operators.pop();
            long n2 = numbers.pop();
            long n1 = numbers.pop();
            if (operator == '+') {
                return (int)(n1 + n2);
            } else {
                return (int)(n1 - n2);
            }
        } else {
            return (int)(long)(numbers.pop());
        }
    }
}
