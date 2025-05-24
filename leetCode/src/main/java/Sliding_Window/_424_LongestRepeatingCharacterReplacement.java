package Sliding_Window;

class _424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int uniqueCount = 0;
        int left = 0;
        int longest = 0;
        int[] count = new int[26];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            uniqueCount = Math.max(uniqueCount, count[c - 'A']);
            int replaceCount = right - left + 1 - uniqueCount;
            if (replaceCount > k) {
                // invalid window
                count[s.charAt(left) - 'A']--;
                left++;
            } else {
                longest = Math.max(longest, right - left + 1);
            }
        }
        return longest;
    }
}
