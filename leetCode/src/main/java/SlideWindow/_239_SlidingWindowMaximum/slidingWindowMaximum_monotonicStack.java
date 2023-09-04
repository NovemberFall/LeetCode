package SlideWindow._239_SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
k = 3
          0  1   2   3  4  5  6  7
         [1, 3, -1, -3, 5, 3, 6, 7]
    DQ:   0
    DQ:      1
    DQ:      1   2                          List[3, ]
    DQ:      1   2   3                      List[3, 3]
    DQ:                                     List[3, 3]   # poll() <== 1, 2, 3
    DQ:                 4                   List[3, 3, 5]
    DQ:                 4  5                List[3, 3, 5, 5]
    DQ:                       6             List[3, 3, 5, 5]  # poll() <== 4, 5
    DQ:                       6             List[3, 3, 5, 5, 6]
    DQ:                          7           List[3, 3, 5, 5, 6, 7]

 */
class slidingWindowMaximum_monotonicStack {

    // Sliding Window
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];

        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            dq.offerLast(i);

            if (i + 1 >= k) {
                res.add(nums[dq.peekFirst()]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        slidingWindowMaximum_monotonicStack slidingWindowMaximumMonotonicStack = new slidingWindowMaximum_monotonicStack();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = slidingWindowMaximumMonotonicStack.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }
}
