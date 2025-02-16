package DynamicProgramming._213_HouseRobber_II;

class _213_HouseRobber_II {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int n = nums.length;
        // Either rob from 0 to n-2 or from 1 to n-1
        return Math.max(maxRobbing(nums, 0, n - 2), maxRobbing(nums, 1, n - 1));
    }

    private int maxRobbing(int[] nums, int left, int right) {

        int n = nums.length;
        int[] dp = new int[n];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[right];
    }
}
