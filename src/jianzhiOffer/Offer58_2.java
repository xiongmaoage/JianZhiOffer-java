package jianzhiOffer;

public class Offer58_2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder str = new StringBuilder(s);
        reverseString(str, 0, str.length() - 1);
        reverseString(str, 0, str.length() - n - 1);
        reverseString(str, str.length() - n, str.length() - 1);
        return str.toString();
    }

    private void reverseString(StringBuilder str, int left, int right) {
        while (left < right) {
            char temp = str.charAt(left);
            str.setCharAt(left, str.charAt(right));
            str.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}
