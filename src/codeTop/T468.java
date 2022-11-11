package codeTop;

public class T468 {
    public String validIPAddress(String queryIP) {
        boolean hasDot = queryIP.contains(".");
        boolean hasColon = queryIP.contains(":");
        if ((hasDot && hasColon) || (!hasDot && !hasColon)) {
            return "Neither";
        }
        if (hasDot) {
            return checkIPv4(queryIP);
        } else {
            return checkIPv6(queryIP);
        }
    }

    private String checkIPv4(String string) {
        String[] segments = string.split("\\.");
        if (segments.length != 4) {
            return "Neither";
        }
        // 如果有第一个和最后一个字符是分隔符导致分割失效，可以直接返回错误
        if (string.charAt(0) == '.' || string.charAt(string.length() - 1) == '.') {
            return "Neither";
        }
        for (int i = 0; i < 4; i++) {
            String ip = segments[i];
            if (ip.length() == 0 || ip.length() > 3) {
                return "Neither";
            }
            //前导0
            if (ip.length() != 1 && ip.charAt(0) == '0') {
                return "Neither";
            }
            int number = 0;
            for (int ii = 0; ii < ip.length(); ii++) {
                if (!Character.isDigit(ip.charAt(ii))) {
                    return "Neither";
                }
                number *= 10;
                number += ip.charAt(ii) - '0';
                if (number > 255) {
                    return "Neither";
                }
            }
        }
        return "IPv4";
    }

    private String checkIPv6(String string) {
        String[] segments = string.split(":");
        if (segments.length != 8) {
            return "Neither";
        }
        // 如果有第一个和最后一个字符是分隔符导致分割失效，可以直接返回错误
        if (string.charAt(0) == ':' || string.charAt(string.length() - 1) == ':') {
            return "Neither";
        }
        for (int i = 0; i < 8; i++) {
            String ip = segments[i];
            if (ip.length() == 0 || ip.length() > 4) {
                return "Neither";
            }
            for (char c : ip.toCharArray()) {
                if (Character.isDigit(c)) {
                    continue;
                }
                if ('a' <= c && c <= 'f') {
                    continue;
                }
                if ('A' <= c && c <= 'F') {
                    continue;
                }
                return "Neither";
            }
        }
        return "IPv6";
    }
}
