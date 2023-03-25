package String._5_LongestPalindromicSubstring;

class longestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        int maxLen = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // odd length
            int oddLeft = i, oddRight = i;
            while (oddLeft >= 0 && oddRight < n && chars[oddLeft] == chars[oddRight]) {
                if (oddRight - oddLeft + 1 > maxLen) {
                    res = s.substring(oddLeft, oddRight + 1);
                    maxLen = oddRight - oddLeft + 1;
                }
                oddLeft--;
                oddRight++;
            }

            // even length
            int evenLeft = i, evenRight = i + 1;
            while (evenLeft >= 0 && evenRight < n && chars[evenLeft] == chars[evenRight]) {
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

    public static void main(String[] args) {
        longestPalindromicSubstring lps = new longestPalindromicSubstring();
        String str = "babadbbbaaa ababababa bbabaab";
        System.out.println(lps.longestPalindrome(str)); // ababababa
    }
}
