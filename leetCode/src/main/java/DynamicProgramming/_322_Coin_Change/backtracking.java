package DynamicProgramming._322_Coin_Change;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class backtracking {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[]{Integer.MAX_VALUE};
        Arrays.sort(coins);
        backtrack(coins, res, amount, new ArrayList<>());
        return res[0] == Integer.MAX_VALUE ? -1 : res[0];
    }

    private void backtrack(int[] coins, int[] res, int remainingAmount, List<Integer> path) {
        if (remainingAmount == 0) {
            res[0] = Math.min(res[0], path.size());
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            if (remainingAmount < 0) {
                return;
            }
            // Optimization: If the current path length is already >= the best result found so far,
            // this path cannot be better, so prune it.
            if (path.size() >= res[0]) {
                continue;
            }
            path.add(coins[i]);
            backtrack(coins, res, remainingAmount - coins[i], path);
            path.remove(path.size() - 1);
        }
    }
}
