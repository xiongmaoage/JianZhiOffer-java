package codeTop;

public class T032 {
    public int longestValidParentheses(String s) {
        int strLen = s.length();
        if (strLen < 2) {
            return 0;
        }
        // 用dp[tail]来记录以tail为结尾的最长匹配字符的长度
        int[] dp = new int[strLen];
        // 记录最长长度
        int ans = -1;
        for (int i = 0; i < strLen; i++) {
            if (i == 0 || s.charAt(i) == '(') {   // 如果以(结尾，则肯定没有匹配的
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {       // 如果括号和前一个匹配，则延伸到前两个的距离
                    if (i == 1) {
                        dp[i] = 2;
                    } else {
                        dp[i] = dp[i - 2] + 2;
                    }
                } else {                            // 如果括号不和前一个匹配，则直接找到前面匹配截止的位置
                    int pair = i - 1 - dp[i - 1];
                    // 如果pair的位置是'('，则pair的位置和i位置匹配，补上前面的长度。否则无法匹配，i位置为多余的)
                    if (pair >= 0 && s.charAt(pair) == '(') {
                        dp[i] = dp[i - 1] + 2;      // 直到pair的距离
                        dp[i] += pair == 0 ? 0 : dp[pair - 1];  // 将从pair-1为结尾的括号长度加上
                    } else {
                        dp[i] = 0;
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
