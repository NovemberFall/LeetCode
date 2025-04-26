package DynamicProgramming._10_RegularExpressionMatching;

class tabulation_v0 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];// Use boolean primitive, defaults to false

        // Base case: empty string and empty pattern match
        dp[m][n] = true;

        // Fill the table bottom-up
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Check if the next pattern character is '*'
                if (j < n - 1 && p.charAt(j + 1) == '*') {
                    // Option 1: Match zero occurrences of p[j] (equivalent to skipping p[j] and '*')
                    boolean match_zero = dp[i][j + 2];

                    // Option 2: Match one or more occurrences of p[j]
                    boolean match_one_plus = false;
                    // Check if current s[i] matches p[j] (and s is not exhausted)
                    if (i < m && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
                        // If they match, it depends on s[i+1:] matching p[j:] (staying at j due to '*')
                        match_one_plus = dp[i + 1][j];
                    }
                    // '*' means zero OR one+ matches are valid
                    dp[i][j] = match_zero || match_one_plus;
                } else {
                    // Normal character match (no '*' following p[j])
                    // Check if current s[i] matches p[j] (and s is not exhausted)
                    if (i < m && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
                        dp[i][j] = dp[i + 1][j + 1];
                    }

                    // No else needed here: if the characters don't match,
                    // dp[i][j] remains default false, which is correct.
                }
            }
        }

        // Result is whether the full string s matches the full pattern p
        return dp[0][0];
    }
}
