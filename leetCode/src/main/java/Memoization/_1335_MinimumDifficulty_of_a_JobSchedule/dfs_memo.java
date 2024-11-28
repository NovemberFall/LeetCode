package Memoization._1335_MinimumDifficulty_of_a_JobSchedule;

import java.util.HashMap;
import java.util.Map;

class dfs_memo {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1; // Not enough jobs for the required days
        }
        Map<String, Integer> cache = new HashMap<>();
        return dfs(0, d, jobDifficulty, cache);
    }

    private int dfs(int i, int d, int[] jobDifficulty, Map<String, Integer> cache) {
        if (i == jobDifficulty.length) {
            return d == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (d == 0) {
            return Integer.MAX_VALUE;
        }

        // Cache key should uniquely identify the state
        String key = i + "," + d;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int curMax = 0;
        int res = Integer.MAX_VALUE;

        // Try ending the current day at each possible job index from i onwards
        for (int j = i; j < jobDifficulty.length; j++) {
            curMax = Math.max(curMax, jobDifficulty[j]);
            int nextDay = dfs(j + 1, d - 1, jobDifficulty, cache);
            if (nextDay != Integer.MAX_VALUE) {
                res = Math.min(res, curMax + nextDay);
            }
        }

        cache.put(key, res);
        return res;
    }
}
