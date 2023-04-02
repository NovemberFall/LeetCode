package DynamicProgramming._122_BestTimeToBuyAndSellStock_II;

class bestTimeToBuyAndSellStock_II_dp {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[] hold = new int[prices.length];
        int[] unhold = new int[prices.length];
        hold[0] = -prices[0];
        unhold[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i - 1], unhold[i - 1] - prices[i]);
            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
        }
        return unhold[prices.length - 1];
    }
}
