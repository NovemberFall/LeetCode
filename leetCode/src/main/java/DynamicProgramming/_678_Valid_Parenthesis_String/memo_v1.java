package DynamicProgramming._678_Valid_Parenthesis_String;

import java.util.Arrays;

class memo_v1 {
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, s, dp);
    }

    private boolean dfs(int index, int openCount, String str, int[][] dp) {
        // If reached end of the string, check if all brackets are balanced
        if (index == str.length()) {
            return openCount == 0;
        }
        if (openCount < 0) {
            return false;
        }


        if (dp[index][openCount] != -1) {
            return dp[index][openCount] == 1;
        }
        boolean isValid = false;
        // If encountering '*', try all possibilities
        if (str.charAt(index) == '(') {
            isValid = dfs(index + 1, openCount + 1, str, dp);
        } else if (str.charAt(index) == ')') {
            isValid = dfs(index + 1, openCount - 1, str, dp);
        } else if (str.charAt(index) == '*') {
            // 1.  Treat '*' as '('
            // 2.  Treat '*' as ')'
            // 3.  Treat '*' as empty
            isValid =  dfs(index + 1, openCount + 1, str, dp)
                    ||  dfs(index + 1, openCount - 1, str, dp)
                    || dfs(index + 1, openCount, str, dp);
        }
        // Memoize and return the result
        dp[index][openCount] = isValid ? 1 : 0;
        return isValid;
    }
}
