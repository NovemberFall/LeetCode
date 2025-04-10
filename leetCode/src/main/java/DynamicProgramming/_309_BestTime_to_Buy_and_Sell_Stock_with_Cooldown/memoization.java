package DynamicProgramming._309_BestTime_to_Buy_and_Sell_Stock_with_Cooldown;

import java.util.Arrays;

class memoization {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] tmp : dp) {
            Arrays.fill(tmp, -1);
        }
        return dfs(prices, 1, dp, 0);
    }

    private int dfs(int[] prices, int isBuy, int[][] dp, int index) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[index][isBuy] != -1) {
            return dp[index][isBuy];
        }
        if (isBuy == 1) {
            int buy = -prices[index] + dfs(prices, 0, dp, index + 1);
            int skip = 0 + dfs(prices, 1, dp, index + 1);
            dp[index][isBuy] = Math.max(buy, skip);
            return dp[index][isBuy];
        } else {
            int sell = prices[index] + dfs(prices, 1, dp, index + 2);
            int hold = 0 + dfs(prices, 0, dp, index + 1);
            dp[index][isBuy] = Math.max(sell, hold);
            return dp[index][isBuy];
        }
    }
}
