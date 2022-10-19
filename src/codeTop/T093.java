package codeTop;

import java.util.ArrayList;
import java.util.List;

public class T093 {
    String string;
    String[] stringList;
    List<String> ans;

    public List<String> restoreIpAddresses(String s) {
        string = s;
        stringList = new String[4];
        ans = new ArrayList<>();
        insertDot(0, 0, 0);
        return ans;
    }

    private void insertDot(int index, int numStart, int dotNum) {
        // 长度到头了或者点数到头了
        if (index == string.length() || dotNum > 3) {
            // 如果到结尾了且点了第四个点，证明最后一段为单独的0。如果不同时满足，说明到头了
            if (dotNum == 4 && index == string.length()) {
                stringList[3] = "0";
                addIp();
            }
            return;
        }
        // 如果当前位是第一个0，则直接在当前位置点
        if (numStart == index && string.charAt(index) == '0') {
            stringList[dotNum] = "0";
            insertDot(index + 1, index + 1, dotNum + 1);
            return;
        }
        // 如果已经有3个点了，则查看最后一个数是否满足要求，如果满足要求则加入
        if (dotNum == 3) {
            long ip = Long.parseLong(string.substring(numStart, string.length()));
            if (ip < 256) {
                stringList[3] = string.substring(numStart, string.length());
                addIp();
            }
            return;
        }
        // 首先检查当前位置是否可以点，如果可以点则查看当前点并传到后面去
        int ip = Integer.parseInt(string.substring(numStart, index + 1));
        if (ip < 256) {
            stringList[dotNum] = string.substring(numStart, index + 1);
            insertDot(index + 1, index + 1, dotNum + 1);
            // 传到下一个位置上
            insertDot(index + 1, numStart, dotNum);
        } else {
            return;
        }
    }

    private void addIp() {
        String s = String.join(".", stringList);
        ans.add(s);
    }
}
