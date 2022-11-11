package codeTop;

public class T088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        for (int pos = m + n - 1; pos >= 0; pos--) {
            if (pointer1 < 0) {
                nums1[pos] = nums2[pointer2--];
            } else if (pointer2 < 0) {
                nums1[pos] = nums1[pointer1--];
            } else if (nums1[pointer1] >= nums2[pointer2]) {
                nums1[pos] = nums1[pointer1--];
            } else {
                nums1[pos] = nums2[pointer2--];
            }
        }
    }
}
