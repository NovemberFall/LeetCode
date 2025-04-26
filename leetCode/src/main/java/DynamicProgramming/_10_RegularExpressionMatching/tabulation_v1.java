package DynamicProgramming._10_RegularExpressionMatching;

class tabulation_v1 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // Use boolean primitive, defaults to false
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty string matches empty pattern
        dp[m][n] = true;

        // Fill the table bottom-up
        // i = index in s (from end to start), j = index in p (from end to start)
        for (int i = m; i >= 0; i--) {
            // Start j from n-1 since dp[...][n] is handled by the base case or implicitly false,
            // except for dp[m][n].
            for (int j = n - 1; j >= 0; j--) {
                // Check if current characters match (only if s is not exhausted(耗尽) at index i)
                boolean first_match = (i < m && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)));

                // Check if the next pattern character is '*'
                if (j < n - 1 && p.charAt(j + 1) == '*') {
                    // If p[j+1] is '*':
                    // Option 1: Treat '*' as zero occurrences of p[j].
                    // Check if s[i:] matches p[j+2:] (equivalent to skipping p[j] and '*')
                    boolean match_zero = dp[i][j + 2];

                    // Option 2: Treat '*' as one or more occurrences of p[j].
                    // Requires current characters to match (first_match)
                    // AND s[i+1:] must match p[j:] (stay at p[j] due to '*')
                    boolean match_one_or_more = first_match && dp[i + 1][j];

                    dp[i][j] = match_zero || match_one_or_more;
                } else {
                    // Normal character match (no '*' following p[j])
                    // Check if current s[i] matches p[j] (and s is not exhausted)
                    dp[i][j] = first_match && dp[i + 1][j + 1];


                    // No else needed here: if the characters don't match,
                    // dp[i][j] remains default false, which is correct.
                }
            }
        }

        // The result is whether the full string s (from index 0) matches the full pattern p (from index 0)
        return dp[0][0];
    }
}
