package codeTop;

import java.util.HashMap;
import java.util.Map;

public class T076 {
    public String minWindow(String s, String t) {
        // 记录t中每个字符的数量
        Map<Character, Integer> targetTimes = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetTimes.put(c, targetTimes.getOrDefault(c, 0) + 1);
        }

        // 找到左右边界，即两侧均不在t中的字符需刨除
        int leftBound = 0;
        while (leftBound < s.length()) {
            if (targetTimes.containsKey(s.charAt(leftBound))) {
                break;
            }
            leftBound++;
        }
        if (leftBound == s.length()) {      // 如果找不到leftbound，说明s中无t
            return "";
        }
        int rightBound = s.length() - 1;
        while (rightBound >= 0) {
            if (targetTimes.containsKey(s.charAt(rightBound))) {
                break;
            }
            rightBound--;
        }

        // 记录窗口中已经出现的每个字符的数量
        Map<Character, Integer> appearTimes = new HashMap<>();
        // 记录最小窗口的左右边界
        int ansLeft = 0;
        int ansRight = s.length();
        int leftPointer = leftBound, rightPointer = leftBound;
        while (true) {
            // 移动右指针直到窗口满足条件
            while (rightPointer <= rightBound) {
                char c = s.charAt(rightPointer);
                if (targetTimes.containsKey(c)) {
                    appearTimes.put(c, appearTimes.getOrDefault(c,0) + 1);
                    if (isCovered(targetTimes, appearTimes)) {
                        break;
                    }
                }
                rightPointer++;
            }
            // 如果已经移出上界，则代表完成算法
            if (rightPointer > rightBound) {
                break;
            }
            // 移动左指针，并同步删除出现的次数
            while (true) {
                char c = s.charAt(leftPointer);
                if (targetTimes.containsKey(c)) {
                    appearTimes.put(c, appearTimes.get(c) - 1);
                    if (!isCovered(targetTimes, appearTimes)) {
                        break;
                    }
                }
                leftPointer++;
            }
            // 此时窗口的位置为leftPointer到rightPointer，可以计算他的长度
            if (rightPointer - leftPointer < ansRight - ansLeft) {
                ansLeft = leftPointer;
                ansRight = rightPointer;
            }
            // 更新pointer
            leftPointer++;
            rightPointer++;
        }
        // 如果当前长度超标，说明没找到，返回空，否则返回子串
        if (ansRight >= s.length()) {
            return "";
        } else {
            return s.substring(ansLeft, ansRight + 1);
        }
    }

    private boolean isCovered(Map<Character, Integer> targetTimes, Map<Character, Integer> appearTimes) {
        for (Character key : targetTimes.keySet()) {
            if (appearTimes.getOrDefault(key, 0) < targetTimes.get(key)) {
                return false;
            }
        }
        return true;
    }
}
