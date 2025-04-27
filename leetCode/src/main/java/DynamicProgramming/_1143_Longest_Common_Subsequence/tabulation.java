package DynamicProgramming._1143_Longest_Common_Subsequence;

class tabulation {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        // dp[i][j] stores the length of the LCS of text1[0...i-1] and text2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    // If characters match, extend the LCS found so far
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    // If characters don't match, take the maximum LCS from the previous subproblems
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        // The length of the LCS of the entire text1 and text2 is at dp[0][0]
        return dp[0][0];
    }
}
