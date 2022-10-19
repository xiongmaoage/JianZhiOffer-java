package codeTop;

public class T072 {
    public int minDistance(String word1, String word2) {
        // 如果有空串，则返回非空串的长度
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        return findMinDistance(word1, word2);
    }

    // 寻找两个字符串你的最长公共子序列（longest common subsequence）的长度
    private int findMinDistance(String word1, String word2) {
        // 动态规划数组，dp[end1][end2]表示word1的前end1个字符转换到word2的前end2个字符的最小步数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化end1和end2为0的情况
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int end1 = 1; end1 <= word1.length(); end1++) {
            for (int end2 = 1; end2 <= word2.length(); end2++) {
                // 最后向第一个串中增加最后一个字符
                int add1 = dp[end1 - 1][end2] + 1;
                // 最后向第二个串中增加最后一个字符
                int add2 = dp[end1][end2 - 1] + 1;
                // 修改最后一个字符为一致
                int update = dp[end1 - 1][end2 - 1];
                if (word1.charAt(end1 - 1) != word2.charAt(end2 - 1)) {
                    update += 1;
                }
                dp[end1][end2] = Math.min(add1, Math.min(add2, update));
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
