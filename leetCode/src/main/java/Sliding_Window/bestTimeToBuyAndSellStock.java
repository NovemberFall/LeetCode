package Sliding_Window;

class bestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1; // left=buy, right=sell
        int maxProfit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left++;
            }
            right++;
        }
        return maxProfit;
    }
}
