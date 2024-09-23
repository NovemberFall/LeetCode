package phone_OA_OnSite.TikTok._673_Number_of_LongestIncreasingSubsequence;

import java.util.Arrays;

class dp {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        // dp[i] means the length of LIS ending at index i
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        // cnt[i] means the number of LIS ending at index i
        int[] cnt = new int[len];

            int res = 0, max = 1;
            for (int i = 0; i < len; i++) {
                int count = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            count = cnt[j];
                        } else if (dp[j] + 1 == dp[i]) {
                            count += cnt[j];
                        }
                    }
                }
                cnt[i] = count;

            if (dp[i] > max) {
                max = dp[i];
                res = count;
            } else if (dp[i] == max) {
                res += count;
            }
        }
        return res;
    }
}
