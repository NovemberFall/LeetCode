package Memoization._1335_MinimumDifficulty_of_a_JobSchedule;

import java.util.HashMap;
import java.util.Map;

class dfs_memo {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) {
            return -1;
        }

        // Set up a cache with a HashMap where key is a string "d, pos" and value is the result
        Map<String, Integer> cache = new HashMap<>();

        return dfs(jobDifficulty, d - 1, 0, cache);
    }

    private int dfs(int[] jobDifficulty, int d, int pos, Map<String, Integer> cache) {
        if (d == 0) {
            int curMax = jobDifficulty[pos];
            for (int i = pos; i < jobDifficulty.length; i++) {
                curMax = Math.max(curMax, jobDifficulty[i]);
            }
            return curMax;
        }

        // Create a unique key for the cache based on `d` and `pos`
        String key = d + "," + pos;

        // Check the cache to avoid redundant calculations
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = pos; i < jobDifficulty.length - d; i++) {
            max = Math.max(max, jobDifficulty[i]);
            min = Math.min(min, max + dfs(jobDifficulty, d - 1, i + 1, cache));
        }

        // Store the computed result in the cache
        cache.put(key, min);

        return min;
    }
}
