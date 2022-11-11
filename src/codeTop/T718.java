package codeTop;

public class T718 {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 滑动窗口，num2从num1的第start位开始
        for (int start = 0; start < nums1.length; start++) {
            // 获取窗口长度，取len1-start和len2的较小值
            int len = Math.min(len1 - start, len2);
            // 比较窗口中的每一个元素，如果相同则对于当前的重复长度+1，如果不相同则将长度置零，并且更新最大长度
            int currentLen = 0;
            for (int i = 0; i < len; i++) {
                if (nums1[start + i] == nums2[i]) {
                    currentLen++;
                } else {
                    ans = Math.max(ans, currentLen);
                    currentLen = 0;
                }
            }
            ans = Math.max(ans, currentLen);
        }
        // 滑动窗口，num1从num2的第start位开始
        for (int start = 0; start < nums2.length; start++) {
            // 获取窗口长度，取len2-start和len1的较小值
            int len = Math.min(len1, len2 - start);
            // 比较窗口中的每一个元素，如果相同则对于当前的重复长度+1，如果不相同则将长度置零，并且更新最大长度
            int currentLen = 0;
            for (int i = 0; i < len; i++) {
                if (nums1[i] == nums2[start + i]) {
                    currentLen++;
                } else {
                    ans = Math.max(ans, currentLen);
                    currentLen = 0;
                }
            }
            ans = Math.max(ans, currentLen);
        }
        return ans;
    }
}
