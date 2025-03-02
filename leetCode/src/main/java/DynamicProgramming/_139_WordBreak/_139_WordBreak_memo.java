package DynamicProgramming._139_WordBreak;

import java.util.Arrays;
import java.util.List;

class _139_WordBreak_memo {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, wordDict, memo, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int[] memo, int index) {
        if (index == s.length()) {
            // Successfully reached the end of the s string.
            return true;
        }
        if (memo[index] != -1) {
            // Return the cached result
            return memo[index] == 1;
        }

        for (String word : wordDict) {
            if (index + word.length() > s.length()) {
                continue;
            }
            // Check if the substring matches the word
            if (s.substring(index, index + word.length()).equals(word)) {
                // Move the index forward by the length of the current word
                if (dfs(s, wordDict, memo, index + word.length())) {
                    memo[index] = 1;
                    return true;
                }
            }
        }

        memo[index] = 0;
        // No valid word break found from this index
        return false;
    }
}
