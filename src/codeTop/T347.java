package codeTop;

import java.util.*;

public class T347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> appearTimes = new HashMap();
        for (int num : nums) {
            appearTimes.put(num, appearTimes.getOrDefault(num, 0) + 1);
        }
        List<Integer[]> timesList = new ArrayList<>();
        for (Integer key : appearTimes.keySet()) {
            timesList.add(new Integer[]{key, appearTimes.get(key)});
        }
        PriorityQueue<Integer[]> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n[1]));
        heap.addAll(timesList);
        for (int i = 0; i < timesList.size() - k; i++) {
            heap.poll();
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            if (heap.isEmpty()) {
                System.out.println("error");
                break;
            }
            ans[i] = (int)heap.poll()[0];
        }
        return ans;
    }
}
