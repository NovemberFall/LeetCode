package _OA_OnSite_tags.TikTok;

import java.util.Arrays;

class _395_LongestSubstringWithAtLeast_K_RepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int maxUnqiueCharCount = getUniqueCharCounts(s);
        int[] freq = new int[26];
        int res = 0;

        for (int curUniqueChars = 1; curUniqueChars <= maxUnqiueCharCount; curUniqueChars++) {
            Arrays.fill(freq, 0);
            int uniqueCount = 0, countOfCharsWithFreqAtLeastK = 0, slow = 0, fast = 0;

            while (fast < s.length()) {
                if (uniqueCount <= curUniqueChars) {
                    int idx = s.charAt(fast) - 'a';
                    if (freq[idx] == 0) {
                        uniqueCount++;
                    }
                    freq[idx]++;

                    if (freq[idx] == k) {
                        countOfCharsWithFreqAtLeastK++;
                    }
                    fast++;
                } else {
                    // we need to shrink
                    int idx = s.charAt(slow) - 'a';
                    if (freq[idx] == k) {
                        countOfCharsWithFreqAtLeastK--;
                    }
                    freq[idx]--;
                    if (freq[idx] == 0) {
                        uniqueCount--;
                    }
                    slow++;
                }

                if (uniqueCount == countOfCharsWithFreqAtLeastK) {
                    res = Math.max(fast - slow, res);
                }
            }
        }
        return res;
    }

    private int getUniqueCharCounts(String s) {
        boolean[] chars = new boolean[26];
        int uniqueCount = 0;
        for (char c : s.toCharArray()) {
            if (!chars[c - 'a']) {
                uniqueCount++;
                chars[c - 'a'] = true;
            }
        }
        return uniqueCount;
    }
}
