package codeTop;

public class T069 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0, right = x / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((double)x / mid == mid) {
                return mid;
            } else if ((double)x / mid > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
