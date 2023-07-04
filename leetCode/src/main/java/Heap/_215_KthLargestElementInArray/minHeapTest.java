package Heap._215_KthLargestElementInArray;

import java.util.Arrays;
import java.util.PriorityQueue;

public class minHeapTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> (a - b)
        );

        int[] nums = new int[]{5, 0, 9, 11, 90, 43, 22, 15, 19, 20};
        for (int num : nums) {
            minHeap.offer(num);
        }
        System.out.println(Arrays.toString(minHeap.toArray()));
        // [0, 5, 9, 11, 20, 43, 22, 15, 19, 90]
    }
}
