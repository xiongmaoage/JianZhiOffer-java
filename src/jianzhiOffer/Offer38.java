package jianzhiOffer;

import java.util.HashSet;
import java.util.Set;


// 输入一个字符串，打印出该字符串中字符的所有排列。

// 注意字符串中含有重复元素的情况
public class Offer38 {
    private StringBuilder string;
    private Set<String> stringSet;

    public String[] permutation(String s) {
        if (s == null || s.isEmpty()) {
            return new String[0];
        }
        this.string = new StringBuilder(s);
        this.stringSet = new HashSet<>();
        permutation(0);
        String[] stringList = new String[stringSet.size()];
        int i = 0;
        for (String str : stringSet) {
            stringList[i] = str;
            i++;
        }
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

    private void swapChar(int index1, int index2) {
        char temp = string.charAt(index1);
        string.setCharAt(index1, string.charAt(index2));
        string.setCharAt(index2, temp);
    }

    private void saveString() {
        String str = new String(this.string);
        stringSet.add(str);
    }
}
