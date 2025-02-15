package _OA_OnSite_tags.TikTok;

class _300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0; // Find the maximum value in LIS
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
