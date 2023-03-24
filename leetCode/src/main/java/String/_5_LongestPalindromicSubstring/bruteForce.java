package String._5_LongestPalindromicSubstring;

class bruteForce {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        // check for every substring
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String temp = s.substring(i, j + 1);
                if (isPalindrome(temp)) {
                    if (maxLen < temp.length()) {
                        sb.setLength(0);
                        maxLen = temp.length();
                        sb.append(temp);
                    }
                }
            }
        }
        return sb.toString();
    }

    private boolean isPalindrome(String temp) {
        int n = temp.length();
        int i = 0, j = n - 1;
        while (i <= j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        bruteForce bf = new bruteForce();
        String str = "babadbbbaaa ababababa bbabaab";
        System.out.println(bf.longestPalindrome(str)); // ababababa
    }
}
