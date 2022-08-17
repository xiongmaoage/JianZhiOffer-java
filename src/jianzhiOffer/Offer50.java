package jianzhiOffer;

// 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

public class Offer50 {
    public char firstUniqChar(String s) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        char ans = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 1) {
                ans = s.charAt(i);
                break;
            }
        }
        return ans;
    }
}
