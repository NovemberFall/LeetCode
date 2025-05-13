package DynamicProgramming._213_HouseRobber_II;

import java.util.Arrays;

class _HouseRobber_II_memo {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int n = nums.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        // Case 1: Rob from 0 to n - 2
        // Case 2: Rob from 1 to n - 1
        return Math.max(f(nums, dp1, 0, n - 2), f(nums, dp2, 1, n - 1));
    }

    private int f(int[] nums, int[] dp, int index, int end) {
        if (index > end) {
            return 0;
        }
        if (index == end) {
            return nums[end];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + f(nums, dp, index + 2, end);
        int notPick = f(nums, dp, index + 1, end);

        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }
}
