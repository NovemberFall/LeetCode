package DynamicProgramming._45_JumpGame_II;

import java.util.Arrays;

class memorization {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, dp, 0);
    }

    private int dfs(int[] nums, int[] dp, int index) {
        if (index == nums.length - 1) {
            return dp[index] = 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int min = 9999;
        for (int i = index + 1; i <= index + nums[index] && i < nums.length; i++) {
            min = Math.min(min, 1 + dfs(nums, dp, i));
        }
        return dp[index] = min;
    }
}
