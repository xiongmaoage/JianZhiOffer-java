package codeTop;

public class T394 {
    String origin;
    int index;
    int len;

    public String decodeString(String s) {
        origin = s;
        index = 0;
        len = origin.length();
        return parseString();
    }

    private String parseString() {
        StringBuilder str = new StringBuilder();
        // 当走到字符串结尾或者走到]时跳出循环
        while (index < len && origin.charAt(index) != ']') {
            while (index < len && Character.isLetter(origin.charAt(index))) {
                str.append(origin.charAt(index));
                index++;
            }
            if (index < len && Character.isDigit(origin.charAt(index))) {
                str.append(parseRepetition());
            }
        }
        return str.toString();
    }

    private String parseRepetition() {
        int repeatTimes = parseInt();
        if (repeatTimes == -1) {
            return "";
        }
        if (origin.charAt(index) != '[') {
            System.out.println("error 0 at " + index);
            return "";
        }
        index++;
        String content = parseString();
        if (origin.charAt(index) != ']') {
            System.out.println("error 2 at " + index);
            return "";
        }
        index++;
        return content.repeat(repeatTimes);
    }

    private int parseInt() {
        if (!Character.isDigit(origin.charAt(index))) {
            System.out.println("error 1 at " + index);
            return -1;
        }
        int ans = 0;
        while (index < len && Character.isDigit(origin.charAt(index))) {
            ans *= 10;
            ans += origin.charAt(index++) - '0';
        }
        return ans;
    }
}
