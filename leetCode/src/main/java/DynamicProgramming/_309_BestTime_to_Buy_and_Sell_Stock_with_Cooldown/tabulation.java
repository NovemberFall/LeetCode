package DynamicProgramming._309_BestTime_to_Buy_and_Sell_Stock_with_Cooldown;

class tabulation {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy <= 1; isBuy++) {
                if (isBuy == 1) {
                    dp[index][isBuy] = Math.max(-prices[index] + dp[index + 1][0],
                            0 + dp[index + 1][1]);
                } else {
                    dp[index][isBuy] = Math.max(prices[index] + dp[index + 2][1],
                            0 + dp[index + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}
