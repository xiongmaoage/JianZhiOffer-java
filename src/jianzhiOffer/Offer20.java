package jianzhiOffer;

//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

// 随时注意字符串越界的问题，可以检查每一次的index++
public class Offer20 {
    private String number;
    private int index = 0;

    public boolean isNumber(String s) {
        if (s.length() < 1 || s.length() > 20) {
            return false;
        }
        this.number = s;

        parseSpace();
        int preIndex = index;
        // 如果匹配小数或整数成功了
        if (parseFloat() || parseInt()) {
            if (index < number.length() && (number.charAt(index) == 'e' || number.charAt(index) == 'E')) {
                if (!parseExponent()) {
                    return false;
                }
            }
            parseSpace();
            return index == number.length();
        }
        return false;
    }

    private boolean parseUnsignedInt() {
        if (index == number.length() || !Character.isDigit(number.charAt(index))) {
            return false;
        }
        while (index < number.length() && Character.isDigit(number.charAt(index))) {
            index++;
        }
        return true;
    }

    private boolean parseInt() {
        if (index == number.length()) {
            return false;
        }
        int preIndex = index;
        if (number.charAt(index) == '+' || number.charAt(index) == '-') {
            index++;
        }
        boolean ans = parseUnsignedInt();
        if (ans) {
            return true;
        } else {
            index = preIndex;
            return false;
        }
    }

    private boolean parseFloat() {
        if (index == number.length()) {
            return false;
        }
        int preIndex = index;
        if (number.charAt(index) == '+' || number.charAt(index) == '-') {
            index++;
        }
        if (index < number.length() && number.charAt(index) == '.') {
            index++;
            boolean ans = parseUnsignedInt();
            if (ans) {
                return true;
            } else {
                index = preIndex;
                return false;
            }
        } else {
            boolean ans = parseUnsignedInt();
            if (index == number.length() || !ans || number.charAt(index) != '.') {
                index = preIndex;
                return false;
            } else {
                index++;
                parseUnsignedInt();
                return true;
            }
        }
    }

    private void parseSpace() {
        while (index < number.length() && number.charAt(index) == ' ') {
            index++;
        }
    }

    private boolean parseExponent() {
        if (index == number.length()) {
            return false;
        }
        if (number.charAt(index) != 'e' && number.charAt(index) != 'E') {
            return false;
        }
        index++;
        return parseInt();
    }
}
