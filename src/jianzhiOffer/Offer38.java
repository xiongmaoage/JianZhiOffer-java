package jianzhiOffer;

// 输入一个字符串，打印出该字符串中字符的所有排列。

import java.util.ArrayList;

public class Offer38 {
    private StringBuilder string;
    private String[] stringList;
    private int stringIndex;

    public String[] permutation(String s) {
        if (s == null || s.isEmpty()) {
            return new String[0];
        }
        this.string = new StringBuilder(s);
        this.stringList = new String[factor(s.length())];
        stringIndex = 0;
        permutation(0);
        return stringList;
    }

    private void permutation(int index) {
        if (index == string.length()) {
            saveString();
            return;
        }
        for (int index2 =  index; index2 < string.length(); index2++) {
            swapChar(index, index2);
            permutation(index + 1);
            swapChar(index, index2);
        }
    }

    private int factor(int a) {
        int ans = 1;
        for (int i = 1; i <= a; i++) {
            ans *= i;
        }
        return ans;
    }

    private void swapChar(int index1, int index2) {
        char temp = string.charAt(index1);
        string.setCharAt(index1, string.charAt(index2));
        string.setCharAt(index2, temp);
    }

    private void saveString() {
        String str = new String(this.string);
        stringList[stringIndex] = str;
        stringIndex++;
    }
}
