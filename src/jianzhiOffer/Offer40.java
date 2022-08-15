package jianzhiOffer;

// 输入整数数组 arr ，找出其中最小的 k 个数

public class Offer40 {
    private int[] arr;

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[0];
        }
        if (k >= arr.length) {
            return arr;
        }
        this.arr = arr;
        int left = 0;
        int right = arr.length;
        int index = partition(left, right);
        while (index != k) {
            if (index < k) {
                left = index + 1;
            } else {
                right = index;
            }
            if (left == right) {
                break;
            }
            index = partition(left, right);
        }
        int[] ans = new int[k];
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    private int partition(int left, int right) {
        if (left >= right) {
            System.out.println("wrong");
            return -1;
        }
        int pixel = arr[left];
        int pSmall = left;
        int pLarge = right - 1;
        while (pSmall < pLarge) {
            while (pSmall < right && arr[pSmall] <= pixel) {
                pSmall++;
            }
            while (pLarge > left && arr[pLarge] > pixel) {
                pLarge--;
            }
            if (pSmall < pLarge) {
                swap(pSmall, pLarge);
            }
        }
        swap(left, pLarge);
        return pLarge;
    }

    private void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
