package DynamicProgramming._322_Coin_Change;

class memo {
    private int[] dp;
    public int coinChange(int[] coins, int amount) {
        // Initialize the dp array with size amount + 1
        // Index 0 will store the result for amount 0, up to index 'amount'
        dp = new int[amount + 1];
        if (amount < 1) {
            return 0;
        }
        return dfs(coins, amount);
    }

    private int dfs(int[] coins, int amount) {
        // Base Case 1: If remaining amount is negative, this path is invalid
        if (amount < 0) {
            return -1;
        }
        // Base Case 2: If remaining amount is 0, we found a valid combination
        if (amount == 0) {
            return 0;// We needed 0 additional coins to reach this state
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        // Try each coin
        for (int coin : coins) {
            // Recursively find the minimum coins for the remaining amount after using the current coin
            int res = dfs(coins, amount - coin);
            if (res == -1) {
                continue;
            }
            // Update the minimum with 1 (for the current coin) + result from subproblem
            min = Math.min(min, 1 + res);
        }

        // Store the result: -1 if amount is unreachable, otherwise the minimum coins
        dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount];
    }
}
