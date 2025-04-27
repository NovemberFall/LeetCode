package DynamicProgramming._44_WildcardMatching;

class tabulation {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base Case: Empty string vs Empty pattern
        dp[m][n] = true;
        for (int i = m; i >= 0; i--) {
            // Iterate through pattern p backwards (j = n-1 to 0)
            // We still need dp[...][n] which is handled by the base case dp[m][n]
            // and the default false for dp[i<m][n].
            for (int j = n - 1; j >= 0; j--) {
                if (p.charAt(j) == '*') {
                    // Option 1: '*' matches zero chars -> dp[i][j+1] (works even if i=m)
                    boolean matchZero = dp[i][j + 1];
                    // Option 2: '*' matches one or more chars -> dp[i+1][j]
                    // This requires i < m (string s must have chars left to match)
                    boolean matchOnePlus = (i < m) && dp[i + 1][j];
                    dp[i][j] = matchZero || matchOnePlus;

                } else { // pChar is '?' or a letter
                    // Match requires:
                    // 1. String s is not empty (i < m)
                    // 2. Pattern char matches string char ('?' or equal letters)
                    if (i < m && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                        // If first chars match, result depends on the rest -> dp[i+1][j+1]
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                    // else: If i == m OR first chars don't match, dp[i][j] remains false (default)
                }
            }
        }
        // Result for full string s[0:] vs full pattern p[0:]
        return dp[0][0];
    }
}
