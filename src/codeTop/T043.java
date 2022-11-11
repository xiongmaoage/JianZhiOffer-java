package codeTop;

public class T043 {
    public String multiply(String num1, String num2) {
        StringBuilder ans = new StringBuilder("0");
        int len2 = num2.length();
        for (int i = 0; i < len2; i++) {
            int n = num2.charAt(len2 - 1 - i) - '0';
            StringBuilder multi = multiplyNumber(num1, n);
            if (!multi.toString().equals("0")) {
                multi.append("0".repeat(i));
            }
            ans = add(ans, multi);
        }
        return ans.toString();
    }

    private StringBuilder multiplyNumber(String string , int n) {
        if (n == 0) {
            return new StringBuilder("0");
        }
        StringBuilder ans = new StringBuilder();
        StringBuilder str = new StringBuilder(string).reverse();
        int jinWei = 0;
        for (int i = 0; i < str.length(); i++) {
            int m = str.charAt(i) - '0';
            ans.append((m * n + jinWei) % 10);
            jinWei = (m * n + jinWei) / 10;
        }
        if (jinWei != 0) {
            ans.append(jinWei);
        }
        return ans.reverse();
    }

    private StringBuilder add(StringBuilder num1, StringBuilder num2) {
        StringBuilder s1 = new StringBuilder(num1).reverse();
        StringBuilder s2 = new StringBuilder(num2).reverse();
        StringBuilder ans = new StringBuilder();
        int jinWei = 0;
        int index = 0;
        while (index < s1.length() || index < s2.length() || jinWei != 0) {
            int n1 = index < s1.length() ? s1.charAt(index) - '0' : 0;
            int n2 = index < s2.length() ? s2.charAt(index) - '0' : 0;
            int sum = jinWei + n1 + n2;
            if (sum >= 10) {
                jinWei = 1;
                sum -= 10;
            } else {
                jinWei = 0;
            }
            ans.append(sum);
            index++;
        }
        return ans.reverse();
    }
}
