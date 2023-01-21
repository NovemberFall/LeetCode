package Heap._215_KthLargestElementInArray;

import java.util.PriorityQueue;

class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> (a - b)
        );

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int res = kthLargestElementInArray.findKthLargest(nums, 4);
        System.out.println(res); // 4
    }
}
