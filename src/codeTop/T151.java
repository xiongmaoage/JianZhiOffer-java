package codeTop;

public class T151 {
    public String reverseWords(String s) {
        StringBuilder string = trimSpaces(s);
        reversePart(string, 0, string.length());
        int lastSpace = -1;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                reversePart(string, lastSpace + 1, i);
                lastSpace = i;
            }
        }
        reversePart(string, lastSpace + 1, string.length());
        return string.toString();
    }

    private StringBuilder trimSpaces(String s) {
        int left = 0;
        while (s.charAt(left) == ' ') {
            left++;
        }
        int right = s.length() - 1;
        while (s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder string = new StringBuilder();
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) != ' ') {
                string.append(s.charAt(i));
            } else {
                if (string.charAt(string.length() - 1) != ' ') {
                    string.append(' ');
                }
            }
        }
        return string;
    }

    private void reversePart(StringBuilder string, int start, int end) {
        if (start >= end) {
            System.out.println("error");
            return;
        }
        int left = start;
        int right = end - 1;
        while (left < right) {
            char temp = string.charAt(left);
            string.setCharAt(left, string.charAt(right));
            string.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}
