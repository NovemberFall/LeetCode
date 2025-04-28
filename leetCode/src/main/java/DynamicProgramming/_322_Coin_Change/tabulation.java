package DynamicProgramming._322_Coin_Change;

class tabulation {
    public int coinChange(int[] coins, int amount) {
        // If amount is zero or less, no coins are needed.
        if (amount < 1) {
            return 0;
        }

        // dp[i] will store the minimum coins needed for amount i.
        int[] dp = new int[amount + 1];

        // Initialize dp array: fill with a large value (amount + 1 works since it's impossible to need more than amount coins)
        java.util.Arrays.fill(dp, amount + 1);

        // base case: 0 coins needed for amount 0
        dp[0] = 0;

        // Iterate through each amount from 1 up to the target amount.
        for (int i = 1; i <= amount; i++) {
            // For each amount, iterate through the available coins.
            for (int coin : coins) {
                // If the current coin can be used to reach amount i from a smaller amount (i - coin >= 0)
                if (i >= coin) {
                    // Update dp[i] with the minimum of its current value and the value from the subproblem (dp[i - coin] + 1 for the current coin).
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still the large initial value, it means the amount is unreachable.
        // Otherwise, it contains the minimum number of coins.
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
