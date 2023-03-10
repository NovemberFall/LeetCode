package DynamicProgramming._55_JumpGame;

// Method 2: DP, canJump[i] means from index `0`, can jump to index i.
public class Solution2 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // if index j is reachable from index 0, and from index j
                // it is possible to jump to index i.
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
                System.out.println();
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        Solution2 solution2 = new Solution2();
        boolean res = solution2.canJump(nums);
        System.out.println(res); // true
    }
}
