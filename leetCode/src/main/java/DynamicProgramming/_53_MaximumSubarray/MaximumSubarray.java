package DynamicProgramming._53_MaximumSubarray;

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            globalMax = Math.max(globalMax, dp[i]);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int res = maximumSubarray.maxSubArray(nums);
        System.out.println(res); // 6
    }
}
