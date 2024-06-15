package phone_OA_OnSite.TikTok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class _465_OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);
        }

        List<Integer> list = new ArrayList<>();
        for (int v : map.values()) {
            if (v != 0) {
                list.add(v);
            }
        }
        return dfs(0, list);
    }

    // return the total number of transactions
    private int dfs(int k, List<Integer> list) {
        if (k == list.size()) {
            return 0; // return 0 transaction
        }
        int cur = list.get(k);
        if (cur == 0) {
            return dfs(k + 1, list);
        }

        int min = Integer.MAX_VALUE;
        for (int i = k + 1; i < list.size(); i++) {
            int next = list.get(i);
            if (cur * next < 0) { // thcek if they are same sign
                list.set(i, cur + next);
                min = Math.min(min, 1 + dfs(k + 1, list));
                list.set(i, next);
            }

            if (cur + next == 0) {
                break;
            }
        }

        return min;
    }
}
