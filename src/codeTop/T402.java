package codeTop;

public class T402 {
    public String removeKdigits(String num, int k) {
        StringBuilder str = new StringBuilder(num);
        for (int index = 1; index < str.length(); index++) {
            while (k > 0 && index > 0 && str.charAt(index) < str.charAt(index - 1)) {
                str.deleteCharAt(index - 1);
                k--;
                // 保持index指向当前较小的数
                index--;
            }
        }
        // 如果有剩下的
        if (k > 0) {
            int end = str.length() - k;
            str = new StringBuilder(str.substring(0, end));
        }
        // 删除前导0
        while (!str.isEmpty() && str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }
        return str.isEmpty() ? "0" : str.toString();
    }
}
