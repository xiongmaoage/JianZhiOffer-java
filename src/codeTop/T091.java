package codeTop;

import java.util.ArrayList;

public class T091 {
    public int numDecodings(String s) {
        if (s.length() == 0 ||  s.charAt(0) == '0') {
            return 0;
        }
        // dp[i]代表前i个字符能有多少种，其中i=0代表没有字符
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(1);
        for (int i = 1; i < s.length(); i++) {
            // 如果当前位是0，则考虑前一位，前一位是1或者2则可以用前两位的值，否则无返回结果
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp.add(dp.get(dp.size() - 2));
                    continue;
                } else {
                    return 0;
                }
            }
            // 如果上一位是0,则当前的组合只能是自己单独成为一个字母
            if (s.charAt(i - 1) == '0') {
                dp.add(dp.get(dp.size() - 1));
            } else {
                int num = Integer.parseInt(s.substring(i - 1, i + 1));
                // 如果当前位置和前一位可以组合成字母，则组合方式为前两次之和，否则只能是前一次
                if (num <= 26) {
                    dp.add(dp.get(dp.size() - 1) + dp.get(dp.size() - 2));
                } else {
                    dp.add(dp.get(dp.size() - 1));
                }
            }
        }
        return dp.get(dp.size() - 1);
    }
}
