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
        // Either rob from 0 to n-2 or from 1 to n-1
        return Math.max(f(n - 2, nums, dp1, 0), f(n - 1, nums, dp2, 1));
    }

    private int f(int index, int[] nums, int[] dp, int start) {
        if (index < start) {
            return 0;
        }
        if (index == start) {
            return nums[start];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + f(index - 2, nums, dp, start);
        int notPick = f(index - 1, nums, dp, start);

        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }
}
