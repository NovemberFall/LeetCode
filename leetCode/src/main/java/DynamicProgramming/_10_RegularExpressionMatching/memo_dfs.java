package DynamicProgramming._10_RegularExpressionMatching;

class memo_dfs {
    private Boolean[][] dp;
    private String s;
    private String p;
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
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Case 1: first char matches, consume one char from s
            // s = aaaxxx   p = a*  这里的p可以等待接下来的char from s, 也就是可以把状态传递给 next dfs
            if (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
                if (dfs(i + 1, j)) {
                    return dp[i][j] = true;
                }
            }

            // Case 2: zero occurrences of char before '*'
            // s = aaaxxx   p = b*  这里的p可以直接表示0个前面字母，所以skip 2 个 chars
            if (dfs(i, j + 2)) {
                return dp[i][j] = true;
            }

            return dp[i][j] = false;
        } else {
            // Second char is not '*'
            if (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
                dp[i][j] = dfs(i + 1, j + 1);
                return dp[i][j];
            }
            return dp[i][j] = false;
        }
    }
}
