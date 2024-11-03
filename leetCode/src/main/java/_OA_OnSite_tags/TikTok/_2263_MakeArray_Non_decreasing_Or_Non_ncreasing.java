package _OA_OnSite_tags.TikTok;

import java.util.PriorityQueue;

class _2263_MakeArray_Non_decreasing_Or_Non_ncreasing {
    public int convertArray(int[] nums) {
        int n = nums.length;
        int res1 = 0;
        int res2 = 0;
        int diff = 0;
        //find the costs to ascending
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            //if current max(cur sea level) is larger than nums[i], that means
            //we need to set it to the new number.
            if (!maxHeap.isEmpty() && maxHeap.peek() >= nums[i]) {
                diff = maxHeap.peek() - nums[i];
                System.out.println("diff: " + diff);
                res1 += diff;
                int head = maxHeap.poll();
                System.out.println("Top: " + head);
                maxHeap.add(nums[i]);
            }
            //if current max is smaller than nums[i], it's already acending
            //just set the new sea level to nums[i]
            maxHeap.add(nums[i]);
        }
        System.out.println("res1: " + res1);

        // vice versa
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < n; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() <= nums[i]) {
                diff = nums[i] - minHeap.peek();
                res2 += diff;
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
            minHeap.offer(nums[i]);
        }
        return Math.min(res1, res2);
    }

    public static void main(String[] args) {
        _2263_MakeArray_Non_decreasing_Or_Non_ncreasing ndna = new _2263_MakeArray_Non_decreasing_Or_Non_ncreasing();
        int[] nums = new int[]{3, 2, 4, 5, 0, 2, 3};
        int res = ndna.convertArray(nums);
//        System.out.println(res);
    }
}
