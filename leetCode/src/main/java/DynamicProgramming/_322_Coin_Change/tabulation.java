package DynamicProgramming._322_Coin_Change;

import java.util.Arrays;

class tabulation {
    public int coinChange(int[] coins, int amount) {
        // If amount is zero or less, no coins are needed.
        if (amount < 1) {
            return 0;
        }

        // dp[i] will store the minimum coins needed for amount i.
        int[] dp = new int[amount + 1];

        // Initialize dp array: fill with a large value
        // (amount + 1 works since it's impossible to need more than amount coins)
        Arrays.fill(dp, amount + 1);

        // base case: 0 coins needed for amount 0
        dp[0] = 0;

        // Iterate through each amount from 1 up to the target amount.
        for (int i = 1; i <= amount; i++) {
            // For each amount 'i', iterate through all available coin denominations.
            for (int coin : coins) {
                // If the current coin can be used to make change for amount 'i'
                // (i.e., if 'i' is greater than or equal to the coin value)
                if (i - coin >= 0) {
                    // We are trying to find the minimum coins for amount 'i'.
                    // One possibility is to use the current 'coin'.
                    // If we use 'coin', the remaining amount needed is 'i - coin'.
                    // The number of coins for this path is 1 (for the current 'coin') + dp[i - coin]
                    // (the minimum coins for the remaining amount).
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still the large initial value, it means the amount is unreachable.
        // Otherwise, it contains the minimum number of coins.
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
