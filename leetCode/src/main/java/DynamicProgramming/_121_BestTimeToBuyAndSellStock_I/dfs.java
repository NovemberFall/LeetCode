package DynamicProgramming._121_BestTimeToBuyAndSellStock_I;

//class dfs {
//    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        return dfs(prices, true, 0, 0);
//    }
//
//    private int dfs(int[] prices, boolean buy, int profit, int index) {
//        if (index >= prices.length) {
//            return 0;
//        }
//        if (buy) {
//            int buyStock = dfs(prices, false, profit - prices[index], index + 1);
//            int skipBuy = 0 + dfs(prices, true, profit, index + 1);
//            return Math.max(buyStock, skipBuy);
//        } else {
//            int sellStock = dfs(prices, true, profit + prices[index], index + 1);
//            int skipSell = 0 + dfs(prices, false, profit, index + 1);
//            return Math.max(sellStock, skipSell);
//        }
//    }
//}
