package DynamicProgramming._44_WildcardMatching;

class memo_dfs {
    Boolean[][] dp;
    String s, p;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (j == p.length()) {
            return dp[i][j] = (i == s.length());
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // --- Main Logic Adapted for LC 44 ---
        // The main difference is how '*' works. It doesn't depend on p[1].

        // Case 1: Current pattern character p[j] is '*'
        if (p.charAt(j) == '*') {
            // Option 1: '*' matches zero characters in s.
            // Check if s matches the rest of the pattern p.charAt(j).
            if (dfs(i, j + 1)) {
                // If skipping '*' leads to a match, return true.
                return dp[i][j] = true;
            }
            // Option 2: '*' matches one or more characters in s.
            // This requires s not to be empty (m > 0).
            // Check if the rest of s (s.substring(1)) matches the current pattern p
            // (we stay at '*' because it can match more).
            if (i < s.length() && dfs(i + 1, j)) {
                return dp[i][j] = true;
            }

            // If neither '*' option leads to a match.
            return dp[i][j] = false;
        } else {
            // Case 2: Current pattern character p[0] is NOT '*' (it's '?' or a letter)
            // This logic block resembles the non-'*' case from your LC10 code.

            // Check if the first characters match:
            // - s must not be empty (m > 0)
            // - EITHER p[0] is '?' (matches any char)     - OR p[0] is the same as s[0]
            if (i < s.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                // If they match, the result depends on the rest of the strings.
                // Recursively call for s.substring(1) and p.substring(1).
                dp[i][j] = dfs(i + 1, j + 1);
                return dp[i][j];
            }

            // If s is empty OR the first characters don't match.
            return dp[i][j] = false; // Store and return false.
        }
    }
}
