package DynamicProgramming._123_BestTimeToBuyAndSellStock_III;

import java.util.PriorityQueue;

class bestTimeToBuyAndSellStock_III_dp {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0]; // 这里也必须是 -prices[0]
        int sell2 = 0;

        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return Math.max(sell1, sell2); // 这里为什么选择其中一个，因为题目最多要求at most 2 transactions
                                       // 也就是说，一次也可以
    }
}
