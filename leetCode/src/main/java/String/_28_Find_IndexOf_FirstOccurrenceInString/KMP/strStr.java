package String._28_Find_IndexOf_FirstOccurrenceInString.KMP;

/**
 * Do pattern matching using KMP algorithm
 * <p>
 * Runtime complexity - O(m + n) where m is length of text and n is the length of pattern
 * Space complexity - O(n)
 */
class strStr {
    public int strStr(String haystack, String needle) {
        return KMP(haystack, needle);
    }

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int j = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                j++;
                i++;
            } else {
                if (j == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        return lps;
    }

    /**
     * KMP algorithm of pattern matching.
     */
    private int KMP(String text, String pattern) {
        int[]lps = buildLPS(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        if (j == pattern.length()) {
            return i - lps.length;
        }
        return -1;
    }
}
