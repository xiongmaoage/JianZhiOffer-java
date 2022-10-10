package codeTop;

import java.util.HashSet;
import java.util.Set;

public class T003 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int maxLen = 0;     // 记录最长距离
        Set<Character> set = new HashSet<>();   // 滑动窗口
        int left = 0, right = 1;    // 左右双指针
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {  // 如果滑动窗口中有该元素，则移动窗口左边界
                // 更新最长距离
                maxLen = Math.max(maxLen, set.size());
                // 更新滑动窗口
                while (left < right && s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++; // 停在c处了，把重复的给去掉
            } else {
                set.add(c);
            }
            right++;
        }
        maxLen = Math.max(maxLen, set.size());
        return maxLen;
    }
}
