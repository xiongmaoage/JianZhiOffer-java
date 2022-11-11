package codeTop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1095 {
    private class MountainArray {
        private List<Integer> list = new ArrayList<>();
        Integer get(int index) { return list.get(index); }
        Integer length() { return list.size(); }
    }

    MountainArray mountain;

    public int findInMountainArray(int target, MountainArray mountainArr) {
        mountain = mountainArr;
        int top = findTop();
        int topValue = mountain.get(top);
        if (target > topValue) {
            return -1;
        } else if (target == topValue) {
            return top;
        }
        int leftIndex = searchUp(target, top);
        if (leftIndex != -1) {
            return leftIndex;
        } else {
            return searchDown(target, top);
        }
    }

    private int findTop() {
        int left = 0, right = mountain.length() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == left) {
                if (left == right) {
                    return left;
                } else {
                    int leftValue = mountain.get(left);
                    int rightValue = mountain.get(right);
                    return leftValue > rightValue ? left : right;
                }
            }
            int midValue = mountain.get(mid);
            int leftValue = mountain.get(mid - 1);
            int rightValue = mountain.get(mid + 1);
            if (leftValue < midValue && midValue > rightValue) {
                return mid;
            } else if (midValue < leftValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int searchUp(int target, int top) {
        int left = 0, right = top - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = mountain.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int searchDown(int target, int top) {
        int left = top + 1, right = mountain.length() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = mountain.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
