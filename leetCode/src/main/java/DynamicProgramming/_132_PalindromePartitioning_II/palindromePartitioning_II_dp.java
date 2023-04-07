package DynamicProgramming._132_PalindromePartitioning_II;

class palindromePartitioning_II_dp {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        char[] arr = s.toCharArray();
        int[] dp = new int[n]; // 这里的dp[] 对应的是每一个char
        dp[0] = 0; // we don't need to cut
        for (int i = 1; i < n; i++) {
            // case 1:
            if (isPalindrome(arr, 0, i)) {
                continue;
            }

            // case 2:
            dp[i] = i; // worst case, we need `i` cut for (i + 1) size array
            for (int j = 1; j <= i; j++) {
                if (isPalindrome(arr, j, i)) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left <= right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
