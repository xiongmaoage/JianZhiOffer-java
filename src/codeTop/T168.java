package codeTop;

public class T168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            int remain = columnNumber % 26;
            if (remain == 0) {
                remain = 26;
                columnNumber -= 26;
            }
            char c = (char)((int)'A' + remain - 1);
            ans.append(Character.toString(c));
            columnNumber /= 26;
        }
        ans.reverse();
        return ans.toString();
    }
}
