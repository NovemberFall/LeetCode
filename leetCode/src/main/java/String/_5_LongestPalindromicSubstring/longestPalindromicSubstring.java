package String._5_LongestPalindromicSubstring;

class longestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String oddStr = expandAroundCenter(s, i, i);
            if (oddStr.length() > res.length()) {
                res = oddStr;
            }

            String evenStr = expandAroundCenter(s, i, i + 1);
            if (evenStr.length() > res.length()) {
                res = evenStr;
            }
        }
        return res;
    }

    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        longestPalindromicSubstring lps = new longestPalindromicSubstring();
        String str = "babadbbbaaa ababababa bbabaab";
        System.out.println(lps.longestPalindrome(str)); // ababababa
    }
}
