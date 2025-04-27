package DynamicProgramming._1143_Longest_Common_Subsequence;

class memorization {
    private Integer[][] dp;
    private String text1;
    private String text2;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;

        // dp[i][j] will store the LCS of text1[0...i-1] and text2[0...j-1]
        dp = new Integer[text1.length() + 1][text2.length() + 1];
        // Start the DFS from the beginning of both strings
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        // Base Case: If either string is fully traversed, LCS length is 0
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // If the characters at the current indices match
        if (text1.charAt(i) == text2.charAt(j)) {
            // Include this matching character and move to the next characters
            dp[i][j] = 1 + dfs(i + 1, j + 1);
        } else {
            // If characters don't match, consider the LCS by
            // 1. Excluding the previous character of text1
            // 2. Excluding the previous character of text2
            // Take the maximum of these two possibilities
            dp[i][j] = Math.max(dfs(i + 1, j), dfs(i, j + 1));
        }
        return dp[i][j];
    }
}
