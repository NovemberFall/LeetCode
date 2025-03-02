package DynamicProgramming._139_WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class _139_WordBreak_dp {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        Set<String> wordSet = new HashSet<>(wordDict);
        for (int lo = 0; lo < n; lo++) {
            for (int hi = lo + 1; hi <= n; hi++) {
                String subStr = s.substring(lo, hi);
                if (dp[0] && wordSet.contains(subStr)) {
                    dp[hi] = true;
                }
            }
        }
        return dp[n];
    }
}
