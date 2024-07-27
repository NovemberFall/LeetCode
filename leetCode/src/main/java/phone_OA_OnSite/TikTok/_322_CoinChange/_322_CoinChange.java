package phone_OA_OnSite.TikTok._322_CoinChange;

import java.util.Arrays;

class _322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int amo = 1; amo <= amount; amo++) {
            for (int coin : coins) {
                if (amo < coin) {
                    continue;
                }
                dp[amo] = Math.min(dp[amo], dp[amo - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
