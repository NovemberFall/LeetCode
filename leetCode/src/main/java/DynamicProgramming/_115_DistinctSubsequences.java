package DynamicProgramming;

class _115_DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();

        int[][] dp = new int[n + 1][m + 1];
        // initialize the dp value when t is an empty string,
        // number of subsequence of an empty string should be 1
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }

        for (int j = 1; j <= n; j++) {
            dp[j][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
