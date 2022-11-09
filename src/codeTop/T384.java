package codeTop;

import java.util.Arrays;
import java.util.Random;

public class T384 {
}

class Solution {
    Random random = new Random();
    int[] origin;
    int[] shuffled;

    public Solution(int[] nums) {
        origin = nums;
        shuffled = reset();
    }

    public int[] reset() {
        shuffled = Arrays.copyOf(origin, origin.length);
        return shuffled;
    }

    public int[] shuffle() {
        for (int current = 0; current < shuffled.length - 1; current++) {
            // 从current到shuffle.length-1中随机采样（random不包含上界，且上界需要大于0）
            int targetIndex = current + random.nextInt(shuffled.length - current);
            swap(shuffled, current, targetIndex);
        }
        return shuffled;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
