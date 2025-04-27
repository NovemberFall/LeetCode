package DynamicProgramming._1143_Longest_Common_Subsequence;

class tabulation {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        // dp[i][j] stores the length of the LCS of text1[0...i-1] and text2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // If characters match, extend the LCS found so far
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum LCS from the previous subproblems
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the LCS of the entire text1 and text2 is at dp[m][n]
        return dp[m][n];
    }
}
