package DynamicProgramming._5_LongestPalindromicSubstring;

/*
    s = "b a b a d"

 */
class solution1 {
    public String longestPalindrome(String s) {
        String res = "";
        int maxLen = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            // odd length
            int oddLeft = i, oddRight = i;
            while (oddLeft >= 0 && oddRight < len && chars[oddLeft] == chars[oddRight]) {
                if (oddRight - oddLeft + 1 > maxLen) {
                    res = s.substring(oddLeft, oddRight + 1);
                    maxLen = oddRight - oddLeft + 1;
                }
                oddLeft--;
                oddRight++;
            }

            // even length
            int evenLeft = i, evenRight = i + 1;
            while (evenLeft >= 0 && evenRight < len && chars[evenLeft] == chars[evenRight]) {
                if (evenRight - evenLeft + 1 > maxLen) {
                    res = s.substring(evenLeft, evenRight + 1);
                    maxLen = evenRight - evenLeft + 1;
                }
                evenLeft--;
                evenRight++;
            }
        }
        return res;
    }
}
