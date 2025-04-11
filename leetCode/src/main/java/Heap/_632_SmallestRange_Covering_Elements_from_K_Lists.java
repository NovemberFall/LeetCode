package Heap;

import java.util.List;
import java.util.PriorityQueue;

class _632_SmallestRange_Covering_Elements_from_K_Lists {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int maxVal = Integer.MIN_VALUE;
        int k = nums.size();

        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            maxVal = Math.max(maxVal, val);
        }

        int start = -100000;
        int end = 100000;
        while (minHeap.size() == k) {
            int[] cur = minHeap.poll();
            int minVal = cur[0];
            int list_index = cur[1];
            int ele_index = cur[2];

            if (maxVal - minVal < end - start) {
                start = minVal;
                end = maxVal;
            }

            if (ele_index < nums.get(list_index).size() - 1) {
                int nextVal = nums.get(list_index).get(ele_index + 1);
                maxVal = Math.max(maxVal, nextVal);
                minHeap.offer(new int[]{nextVal, list_index, ele_index + 1});
            }
        }
        return new int[]{start, end};
    }
}
