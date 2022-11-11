package codeTop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 记录以每一个字符为结尾的单词。每一个List都分别代表以某个字母为结尾的列表
        List<String>[] alphabet = new List[26];
        for (String word : wordDict) {
            char lastChar = word.charAt(word.length() - 1);
            List<String> list = alphabet[lastChar - 'a'];
            if (list == null) {
                alphabet[lastChar - 'a'] = new LinkedList<>();
            }
            alphabet[lastChar - 'a'].add(word);
        }
        // 使用动归，针对截止到pos的位置查看是否有组织方式
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, false);
        for (int pos = 0; pos < s.length(); pos++) {
            char c = s.charAt(pos);
            List<String> wordList = alphabet[c - 'a'];
            if (wordList != null) {
                for (String word : wordList) {
                    int len = word.length();
                    if (len == pos + 1 || (len < pos + 1 && dp[pos - len])) {
                        if (word.equals(s.substring(pos - len + 1, pos + 1))) {
                            dp[pos] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
