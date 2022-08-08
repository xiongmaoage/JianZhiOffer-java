package jianzhiOffer;

// 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
// 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。


public class Offer19 {
    private String pattern;
    private String target;

    public boolean isMatch(String s, String p) {
        target = s;
        pattern = p;
        return match(0, 0);
    }

    private boolean match(int targetPos, int patternPos) {
        // 如果模式匹配完，看字符串匹配情况
        if (patternPos == pattern.length()) {
            return targetPos == target.length();
        }
        // 查看当前需要匹配的字符是否是后面跟着*
        if (patternPos + 1 < pattern.length() && pattern.charAt(patternPos + 1) == '*') {
            if (matchChar(targetPos, patternPos)) {
                // 接受当前匹配值，继续匹配*
                if (match(targetPos + 1, patternPos)) return true;
                // 接受当前匹配值，完成对*的匹配
                if (match(targetPos + 1, patternPos + 2)) return true;
                // 直接完成对*的匹配
                if (match(targetPos, patternPos + 2)) return true;
                return false;
            } else { // 匹配不上，放弃*的匹配
                return match(targetPos, patternPos + 2);
            }
        } else {    // 如果没有星号，直接看是否匹配
            if (matchChar(targetPos, patternPos)) {
                return match(targetPos + 1, patternPos + 1);
            } else {
                return false;
            }
        }
    }

    private boolean matchChar(int targetIndex, int patternIndex) {
        if (targetIndex >= target.length() || patternIndex >= pattern.length()) {
            return false;
        }
        char patternChar = pattern.charAt(patternIndex);
        char targetChar = target.charAt(targetIndex);
        if (patternChar == '.') {
            return true;
        } else {
            return targetChar == patternChar;
        }
    }
}
