package DynamicProgramming;

/**
 * How does "ablmy" stand true to "a*b.*y"?
 * <p>
 * a* ---> a
 * b ---> b
 * .* ----> . . ----> lm
 * y ----> y
 * <p>
 * In regular expression, single * has no meaning. It has to be *
 * Examples:
 * a*
 * b*
 * .*
 */
class _10_RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
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
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                        // 当*的前一位是'.'， 或者前一位的pc等于sc的话，
                        // *代表1个(dp[i][j - 1])，*代表多个(dp[i - 1][j])，或者用*消掉c*(dp[i][j - 2])
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
        boolean res = isMatch(text, pattern);
        System.out.println(res);
    }
}
