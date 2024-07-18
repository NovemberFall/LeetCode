package phone_OA_OnSite.TikTok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class _465_OptimalAccountBalancing {
    int res = Integer.MAX_VALUE;
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }

        List<Integer> list = new ArrayList<>();
        for (int v : map.values()) {
            if (v != 0) {
                list.add(v);
            }
        }
        dfs(0, 0, list);
        return res;
    }

    // return the total number of transactions
    private void dfs(int startIndex, int count, List<Integer> list) {
        while (startIndex < list.size() && list.get(startIndex) == 0) {
            startIndex++;
        }
        if (startIndex == list.size()) {
            res = Math.min(res, count);
            return;
        }

        for (int i = startIndex + 1; i < list.size(); i++) {
            // check if they are same sign
            // if (list.get(startIndex) * list.get(i)) < 0
            if ((list.get(startIndex) < 0 && list.get(i) > 0) || (list.get(startIndex) > 0 && list.get(i) < 0)) {
                list.set(i, list.get(i) + list.get(startIndex));
                dfs(startIndex + 1, count + 1, list);
                list.set(i, list.get(i) - list.get(startIndex));
            }
        }
    }

    public static void main(String[] args) {
        _465_OptimalAccountBalancing optimalAccountBalancing = new _465_OptimalAccountBalancing();
        int[][] transactions = new int[][]{{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};
        int res = optimalAccountBalancing.minTransfers(transactions);
        System.out.println(res);
    }
}
