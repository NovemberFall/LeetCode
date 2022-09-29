package BFS._322_CoinChange;

import java.util.LinkedList;
import java.util.Queue;

class CoinChange_v1 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int base = queue.poll();
                for (int coin : coins) {
                    int value = base + coin;
                    if (value == amount) {
                        return level;
                    } else if (value > amount) {
                        continue;
                    } else {
                        queue.offer(value);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CoinChange_v1 coinChange_v1 = new CoinChange_v1();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int count = coinChange_v1.coinChange(coins, amount);
        System.out.println(count);
    }
}
