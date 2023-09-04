package SlideWindow._239_SlidingWindowMaximum;

import java.util.ArrayList;
import java.util.List;

class slidingWindowMaximum_bruteForce {
    // Brute Force
    public static int[] maxSlidingWindow_BruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];

        List<Integer> res = new ArrayList<>();
        for (int i = k - 1; i < nums.length; i++) {
            int curMax = nums[i];
            for (int j = 0; j < k; j++) {
                curMax = Math.max(curMax, nums[i - j]);
            }
            res.add(curMax);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
