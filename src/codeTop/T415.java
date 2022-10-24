package codeTop;

public class T415 {
    public String addStrings(String num1, String num2) {
        StringBuilder a1 = new StringBuilder(num1).reverse();
        StringBuilder a2 = new StringBuilder(num2).reverse();
        // 保障a1的长度比a2长
        if (a1.length() < a2.length()) {
            StringBuilder temp = a1;
            a1 = a2;
            a2 = temp;
        }
        StringBuilder ans = new StringBuilder();
        int jinWei = 0;
        for (int i = 0; i < a1.length(); i++) {
            int n1 = a1.charAt(i) - '0';
            int n2 = i < a2.length() ? (a2.charAt(i) - '0') : 0;
            int sum = n1 + n2 + jinWei;
            if (sum >= 10) {
                ans.append((char)('0' + sum - 10));
                jinWei = 1;
            } else {
                ans.append((char)('0' + sum));
                jinWei = 0;
            }
        }
        if (jinWei == 1) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }
}
