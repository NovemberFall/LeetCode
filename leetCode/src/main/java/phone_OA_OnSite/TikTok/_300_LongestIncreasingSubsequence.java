package phone_OA_OnSite.TikTok;

class _300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] T = new int[n];
        for (int i = 0; i < n; i++) {
            T[i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    T[i] = Math.max(T[i], 1 + T[j]);
                }
            }
        }

        int maxLen = 1; // Find the maximum value in LIS
        for (int len : T) {
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
