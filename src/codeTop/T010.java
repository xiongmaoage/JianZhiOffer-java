package codeTop;

public class T010 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        int p1 = 0, p2 = 0;
        while (p2 < p.length()) {
            // 如果当前字符是带点的，则分类匹配
            if (p2 + 1 < p.length() && p.charAt(p2 + 1) == '*') {
                boolean ans = isMatch(s.substring(p1), p.substring(p2 + 2));
                while (!ans && p1 < s.length() && (p.charAt(p2) == '.' || s.charAt(p1) == p.charAt(p2))) {
                    p1++;
                    ans = isMatch(s.substring(p1), p.substring(p2 + 2));
                }
                return ans;
            }
            if (p1 == s.length()) {
                break;
            } else if (p.charAt(p2) == '.' || s.charAt(p1) == p.charAt(p2)) {
                p1++;
                p2++;
            } else {
                return false;
            }
        }
        return p1 == s.length() && p2 == p.length();
    }
}
