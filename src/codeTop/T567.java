package codeTop;

import java.util.HashMap;
import java.util.Map;

public class T567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        // 记录s1中各个字符出现的次数
        Map<Character, Integer> timesInS1 = new HashMap<>();
        // 统计s1中各个字符的的出现次数
        for (char c : s1.toCharArray()) {
            timesInS1.put(c, timesInS1.getOrDefault(c, 0) + 1);
        }
        // 设置一个滑动窗口，并记录窗口中各个字符出现的次数，只记录s1中有的字符
        int windowSize = s1.length();
        Map<Character, Integer> timeInWindow = new HashMap<>();
        // 初始化窗口
        for (int index = 0; index < windowSize; index++) {
            char c = s2.charAt(index);
            if (timesInS1.containsKey(c)) {
                timeInWindow.put(c, timeInWindow.getOrDefault(c, 0) + 1);
            }
        }
        if (isEqualMap(timesInS1, timeInWindow)) {
            return true;
        }
        for (int index = windowSize; index < s2.length(); index++) {
            // 更新窗口中的统计内容
            int delete = index - windowSize;
            char c = s2.charAt(index);
            char deleteChar = s2.charAt(delete);
            if (timesInS1.containsKey(deleteChar)) {
                timeInWindow.put(deleteChar, timeInWindow.get(deleteChar) - 1);
            }
            if (timesInS1.containsKey(c)) {
                timeInWindow.put(c, timeInWindow.getOrDefault(c, 0) + 1);
            }
            if (isEqualMap(timesInS1, timeInWindow)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqualMap(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (Character key : map1.keySet()) {
            if (!map2.containsKey(key) || !map2.get(key).equals(map1.get(key))) {
                return false;
            }
        }
        return true;
    }
}
