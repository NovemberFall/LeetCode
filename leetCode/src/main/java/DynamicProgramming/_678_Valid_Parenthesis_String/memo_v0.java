package DynamicProgramming._678_Valid_Parenthesis_String;
import java.util.Arrays;

class memo_v0 {
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
        if (dp[index][openCount] != -1) {
            return dp[index][openCount] == 1;
        }
        boolean isValid = false;
        // If encountering '*', try all possibilities
        if (str.charAt(index) == '*') {
            boolean asOpen = dfs(index + 1, openCount + 1, str, dp); // Treat '*' as '('
            boolean asClose = openCount > 0 && dfs(index + 1, openCount - 1, str, dp); // Treat '*' as ')'
            boolean asEmpty = dfs(index + 1, openCount, str, dp); // Treat '*' as empty
            isValid = asOpen || asClose || asEmpty;
        } else {
            // Handle '(' and ')'
            if (str.charAt(index) == '(') {
                isValid = dfs(index + 1, openCount + 1, str, dp);
            } else if (openCount > 0) {
                isValid = dfs(index + 1, openCount - 1, str, dp);
            }
        }

        // Memoize and return the result
        dp[index][openCount] = isValid ? 1 : 0;
        return isValid;
    }
}
