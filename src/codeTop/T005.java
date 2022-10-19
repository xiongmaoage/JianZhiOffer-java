package codeTop;

public class T005 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String longest = "";
        for (int center = 0; center < s.length(); center++) {
            // 奇数回文
            String oddString = findFromCore(s, center, center);
            if (oddString.length() > longest.length()) {
                longest = oddString;
            }
            // 偶数回文
            if (center != s.length() - 1 && s.charAt(center) == s.charAt(center + 1)) {
                String evenString = findFromCore(s, center, center + 1);
                if (evenString.length() > longest.length()) {
                    longest = evenString;
                }
            }
        }
        return longest;
    }

    private String findFromCore(String s, int centerStart, int centerEnd) {
        int left = centerStart, right = centerEnd;
        do {
            left--;
            right++;
        } while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right));
        return s.substring(left + 1, right);
    }
}
