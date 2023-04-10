package DynamicProgramming._132_PalindromePartitioning_II;

import java.util.Arrays;

class palindromePartitioning_II_2d_dp {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        //dp[i][j] represents the string starting from i and ending at j
        //Eg : abcd dp[1][3] means bcd
        int[][] dp = new int[n][n];

        //It will form an upper triangle

        //Length l=1
        //For each string which has only 1 alphabet -> min cut is 0
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        //Length l=2
        //For string of length 2 -> If both alphabets same then min cut is 0 else 1
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 0;
            } else {
                dp[i][i + 1] = 1;
            }
        }

        //Length 3 to n
        //Perfect method to move diagonally in matrix
        //similar approach in the Longest palindrome substring problem
        for (int l = 3; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (isPalindrome(s, i, j)) {
                    dp[i][j] = 0;
                } else {
                    for (int k = i; k < j; k++) {
                        int cur = 1 + dp[i][k] + dp[k + 1][j]; // Making one cut and checking the other two parts
                        dp[i][j] = Math.min(dp[i][j], cur);
                    }
                }// else
            }//i
        }//l
        return dp[0][n - 1];
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}