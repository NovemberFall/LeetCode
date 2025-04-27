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

    private int dfs(int[] coins, int remaining) {
        if (remaining < 0) {
            return -1;
        }
        if (remaining == 0) {
            return 0;// We needed 0 additional coins to reach this state
        }
        if (dp[remaining] != 0) {
            return dp[remaining];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, remaining - coin);

            // If the recursive call returned a valid result (not -1, meaning possible)
            // AND this result + 1 (for the current coin) is better than the current minimum
            if (res >= 0 && res < min) {
                min = res + 1; // +1 because we are adding the current 'coin'
            }
        }
        dp[remaining] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[remaining];
    }
}
