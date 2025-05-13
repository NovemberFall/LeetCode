package DynamicProgramming._198_HouseRobber;

import java.util.Arrays;

class _198_HouseRobber_memo {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, nums, dp);
    }

    private int f(int index, int[] nums, int[] dp) {
        if (index == nums.length - 1) {
            return nums[index];
        }
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int pick = nums[index] + f(index + 2, nums, dp);
        int notPick = f(index + 1, nums, dp);
        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }
}
