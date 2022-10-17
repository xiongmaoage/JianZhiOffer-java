package codeTop;

import utils.ListNode;

public class T008 {
    public int myAtoi(String s) {
        String number = abandonSpace(s);
        if (number.length() == 0) {
            return 0;
        } else if (number.length() == 1) {
            if (Character.isDigit(number.charAt(0))) {
                return number.charAt(0) - '0';
            } else {
                return 0;
            }
        }
        boolean isPositive = true;
        if (number.charAt(0) == '+') {
            number = number.substring(1);
        } else if (number.charAt(0) == '-') {
            isPositive = false;
            number = number.substring(1);
        } else if (!Character.isDigit(number.charAt(0))) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                break;
            }
            long newNum = 10L * num + number.charAt(i) - '0';
            if (isPositive && newNum >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (!isPositive && -newNum <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            num = (int)newNum;
        }
        if (isPositive) {
            return num;
        } else {
            return -num;
        }
    }

    private String abandonSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }
        if (i == s.length()) {
            return "";
        } else {
            return s.substring(i);
        }
    }
}
