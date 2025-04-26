package DynamicProgramming._10_RegularExpressionMatching;

class memorization_dfs {
    private Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p);
    }

    private boolean dfs(String s, String p) {
        int m = s.length(), n = p.length();
        if (dp[m][n] != null) {
            return dp[m][n];
        }
        if (n == 0) {
            return dp[m][n] = (m == n);
        }
        if (n > 1 && p.charAt(1) == '*') {
            // Case 1: zero occurrences of char before '*'
            if (dfs(s, p.substring(2))) {
                return dp[m][n] = true;
            }
            // Case 2: first char matches, consume one char from s
            if (m > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                if (dfs(s.substring(1), p)) {
                    return dp[m][n] = true;
                }
            }
            return dp[m][n] = false;
        } else {
            // Second char is not '*'
            if (m > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                dp[m][n] = dfs(s.substring(1), p.substring(1));
                return dp[m][n];
            }
            return dp[m][n] = false;
        }
    }
}
