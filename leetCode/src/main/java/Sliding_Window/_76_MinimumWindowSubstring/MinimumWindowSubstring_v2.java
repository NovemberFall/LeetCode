package Sliding_Window._76_MinimumWindowSubstring;

class MinimumWindowSubstring_v2 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // Maintain two arrays to record the frequency of characters in the current window and the target string.
        // The ASCII table has a total length of 128, ranging from 0 to 127 (e.g., ascii('z') = 122).
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];

        // Record the frequency of characters in the target string.
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }

        // Left pointer, right pointer, and the minimum length (initialized to an unattainable value).
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;

        // `matchingCharsCount` represents the number of characters in the current window that match the target string.
        // This count increases only when a character in the window matches the required frequency in `tFreq`.
        int matchingCharsCount = 0;
        int start = 0;

        // [left, right)
        while (right < s.length()) {

            // If the current character at `right` is not in `t`, move the right pointer directly.
            if (tFreq[s.charAt(right)] == 0) {
                right++;
                continue;
            }

            /* Example:
                 s = F F A D D B A C C D E N C        t = A A B
                 When encountering 'A' for the first time:
                 winFreq[A] = 0,  tFreq[A] = 2
                 => winFreq[s[right]] < tFreq[s[right]], so we increase `matchingCharsCount`.
            */
            // When expanding the right boundary, if the count of `s[right]` in `winFreq` is less than in `tFreq`,
            // we increase `matchingCharsCount`.
            if (winFreq[s.charAt(right)] < tFreq[s.charAt(right)]) {
                matchingCharsCount++;
            }

            // Increase the frequency count of `s[right]` in the window.
            winFreq[s.charAt(right)]++;

            // When the current window contains all characters of `t` with the required frequency.
            while (matchingCharsCount == t.length()) {
                // If the current window size is smaller than the previously recorded minimum, update `minLen` and `start`.
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // If the character at `left` is not needed in `t`, move the left pointer directly.
                if (tFreq[s.charAt(left)] == 0) {
                    left++;
                    continue;
                }

                // When shrinking the left boundary, if `winFreq[s[left]]` equals `tFreq[s[left]]`,
                // we must decrease `matchingCharsCount`.
                if (winFreq[s.charAt(left)] == tFreq[s.charAt(left)]) {
                    matchingCharsCount--;
                }

                // Decrease the frequency count of `s[left]` in the window.
                winFreq[s.charAt(left)]--;
                // Move the left pointer.
                left++;
            }
            // Move the right pointer.
            right++;
        }

        // If `minLen` is still the initial value, no valid substring was found.
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}
