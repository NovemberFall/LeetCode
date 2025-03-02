package DynamicProgramming._139_WordBreak;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class _139_WordBreak_memo_map {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(s, wordDict, memo, 0);
    }

    private boolean dfs(String s, List<String> wordDict, Map<Integer, Boolean> memo, int index) {
        if (index == s.length()) {
            // Successfully reached the end of the s string.
            return true;
        }
        if (memo.containsKey(index)) {
            // Return the cached result
            return memo.get(index);
        }

        for (String word : wordDict) {
            if (index + word.length() > s.length()) {
                continue;
            }
            // Check if the substring matches the word
            if (s.substring(index, index + word.length()).equals(word)) {
                // Move the index forward by the length of the current word
                if (dfs(s, wordDict, memo, index + word.length())) {
                    memo.put(index, true);
                    return true;
                }
            }
        }

        memo.put(index, false);
        // No valid word break found from this index
        return false;
    }
}
