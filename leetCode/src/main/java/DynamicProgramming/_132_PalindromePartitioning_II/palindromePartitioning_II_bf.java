package DynamicProgramming._132_PalindromePartitioning_II;

import com.sun.scenario.effect.Brightpass;

class palindromePartitioning_II_bf {
    public int minCut(String s) {
        return minCutFrom(s, 0, s.length() - 1);
    }

    private int minCutFrom(String s, int left, int right) {
        if (left == right || isPalindrome(s, left, right)) {
            return 0;
        }
        int minCut = s.length() - 1;
        for (int i = left; i <= right; i++) {
            if (isPalindrome(s, left, i)) {
                minCut = Math.min(minCut, 1 + minCutFrom(s, i + 1, right));
            }
        }
        return minCut;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        palindromePartitioning_II_bf palindromePartitioning_ii_bf = new palindromePartitioning_II_bf();
        int cuts = palindromePartitioning_ii_bf.minCut("ababacde");
        System.out.println(cuts); // 3
    }
}
