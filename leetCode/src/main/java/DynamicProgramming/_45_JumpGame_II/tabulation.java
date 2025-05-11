package DynamicProgramming._45_JumpGame_II;

class tabulation {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;

        for (int index = nums.length - 2; index >= 0; index--) {
            int min = 99999;
            for (int i = index + 1; (i <= index + nums[index]) && i < nums.length; i++) {
                min = Math.min(min, dp[i] + 1);
            }
            dp[index] = min;
        }
        return dp[0];
    }
}
