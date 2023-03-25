package String._5_LongestPalindromicSubstring;

class extendFromCenter {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int start = 0, end = 0;
        int maxLen = 0;
        int n = s.length();

        // i 不能从`index 0`开始，因为无法向左边扩张
        for (int i = 1; i < n; i++) {
            // odd check
            int len1 = extendByCenter(s, i, i);

            // even check
            int len2 = extendByCenter(s, i - 1, i);

            if (len1 > maxLen) {
                start = i - len1 / 2;
                end = i + len1 / 2;
                maxLen = len1;
            }

            if (len2 > maxLen) {
                start = i - len2 / 2;
                end = i - 1 + len2 / 2;
                maxLen = len2;
            }
        }

        // substring， end 是不包含的，所以得 + 1
        return s.substring(start, end + 1);
    }

    private int extendByCenter(String s, int lo, int hi) {
        int maxLen = 1;
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            maxLen = hi - lo + 1;
            lo--;
            hi++;
        }
        return maxLen;
    }
}
