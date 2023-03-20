package DynamicProgramming._139_WordBreak;

import java.util.List;

class wordBreak_Optimal {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int lo = 0; lo < n; lo++) {
            if (!dp[lo]) {
                continue;
            }
            for (String word : wordDict) {
                int hi = lo + word.length();
                if (hi <= n && s.substring(lo, hi).equals(word)) {
                    dp[hi] = true;
                }
            }
        }
        return dp[n];
    }
}
