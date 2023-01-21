package Heap._215_KthLargestElementInArray;

import java.util.PriorityQueue;

//class KthLargestElementInArray_Online {
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
//                (a, b) -> (b - a)
//        );
//
//        for (int i = 0; i < nums.length; i++) {
//            if (i < k) {
//                maxHeap.offer(nums[i]);
//            } else if (nums[i] > maxHeap.peek()) {
//                maxHeap.poll();
//                maxHeap.offer(nums[i]);
//            }
//        }
//
//        for (int i = k - 1; i > 0; i--) {
//            maxHeap.poll();
//        }
//        return maxHeap.peek();
//    }
//}
