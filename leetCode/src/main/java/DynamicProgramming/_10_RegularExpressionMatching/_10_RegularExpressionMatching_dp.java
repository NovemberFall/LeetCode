package DynamicProgramming._10_RegularExpressionMatching;

/**
    '.' Matches any single character.
    '*' Matches zero or more of the preceding element
 ------------------------------------------------


    How does "ablmy" stand true to "a*b.*y"?

    a* ---> a
    b ---> b
    .* ----> . . ----> lm
    y ----> y

    In regular expression, single * has no meaning. It has to be *
    Concepts_Examples:
    a*
    b*
    .*
 */
class _10_RegularExpressionMatching_dp {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 2; i < dp[0].length; i += 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2]; // *可以消掉c*
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // s = xaa   p = xa*
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                        // 当*的前一位是'.'， 或者前一位的pc等于sc的话，
                        // *代表1个(dp[i][j - 1])  *代表多个(dp[i - 1][j])，或者用*消掉c*(dp[i][j - 2])
                    } else {
                        dp[i][j] = dp[i][j - 2]; // 用*消掉c*
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text = "xaabyc", pattern = "xa*b.c";
        _10_RegularExpressionMatching_dp dp = new _10_RegularExpressionMatching_dp();
        boolean res = dp.isMatch(text, pattern);
        System.out.println(res);
    }
}


/*

 Induction rule is very similar to edit distance, where we also consider from the end.
 And it is based on what character in the pattern we meet.
 1. if p.charAt(j) == s.charAt(i), M[i][j] = M[i - 1][j - 1]
    ######a(i)
    ####a(j)
 2. if p.charAt(j) == '.', M[i][j] = M[i - 1][j - 1]
 	#######a(i)
    ####.(j)
 3. if p.charAt(j) == '*':
    1. if p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i), then b* is counted as empty. M[i][j] = M[i][j - 2]
       #####a(i)
       ####b*(j)
    2.if p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i):
       ######a(i)
       ####.*(j)

 	   #####a(i)
       ###a*(j)
      2.1 if p.charAt(j - 1) is counted as empty, then M[i][j] = M[i][j - 2]
      2.2 if counted as one or multiple, then the pattern can be expanded with one more a*: "####xa*a*",
                                                                                           then M[i][j] = M[i - 1][j]
 	   #####a(i)
       ###a*a*(j)

 */
