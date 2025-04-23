package DynamicProgramming._678_Valid_Parenthesis_String;

class tabulation {
    public boolean checkValidString(String s) {
        int n = s.length();
        // Increased size to n+2 to handle openCount + 1 safely
        boolean[][] dp = new boolean[n + 1][n + 2];
        dp[n][0] = true;  // base case

        for (int index = n - 1; index >= 0; index--) {
            for (int openCount = 0; openCount <= n; openCount++) {
                char c = s.charAt(index);
                boolean isValid = false;

                if (c == '(') {
                    isValid = dp[index + 1][openCount + 1];  // treat as open
                } else if (c == ')') {
                    if (openCount > 0)
                        isValid = dp[index + 1][openCount - 1];  // treat as close
                } else if (c == '*') {
                    isValid = dp[index + 1][openCount + 1]      // treat as '('
                                    || (openCount > 0 && dp[index + 1][openCount - 1])  // treat as ')'
                                    || dp[index + 1][openCount];      // treat as empty
                }
                dp[index][openCount] = isValid;
            }
        }

        return dp[0][0];
    }
}
