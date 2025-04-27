package DynamicProgramming._1143_Longest_Common_Subsequence;

class memorization_v0 {
    private Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length() + 1][text2.length() + 1];
        return dfs(text1, text2);
    }

    private int dfs(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != null) {
            return dp[m][n];
        }

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            // Characters match, include in LCS
            dp[m][n] = 1 + dfs(text1.substring(0, m - 1), text2.substring(0, n - 1));
        } else {
            // Characters don't match, take the maximum of excluding one character from either string
            dp[m][n] = Math.max(dfs(text1.substring(0, m - 1), text2), dfs(text1, text2.substring(0, n - 1)));
        }
        return dp[m][n];
    }
}
