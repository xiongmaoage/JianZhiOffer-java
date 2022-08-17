package jianzhiOffer;

// 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

import java.util.HashMap;
import java.util.HashSet;

// 只用一个map记录每一个字符出现的最后一个位置就可以了
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> char2Index = new HashMap<>();
        int maxLen = 0;        // 用来记录长度的最大值
        int currentLen = 0;    // 用来记录当前长度
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastIndex = char2Index.getOrDefault(c, -1);
            // 需要加入该字符，具体体现为该字符没出现过，或者出现的距离长于目前的距离
            if (lastIndex < 0 || i - lastIndex > currentLen) {
                currentLen++;
            } else {
                currentLen = i - lastIndex;
            }
            maxLen = Math.max(currentLen, maxLen);
            char2Index.put(c, i);
        }
        return maxLen;
    }
}
