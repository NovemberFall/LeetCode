package Memoization._1335_MinimumDifficulty_of_a_JobSchedule;

// Without memoization, I get TLE
class dfs_without_memo {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) {
            return -1;
        }
        return dfs(jobDifficulty, d - 1, 0);
    }

    private int dfs(int[] jobDifficulty, int day, int pos) {
        if (day == 0) {
            int curMax = jobDifficulty[pos];
            for (int i = pos; i < jobDifficulty.length; i++) {
                curMax = Math.max(curMax, jobDifficulty[i]);
            }
            return curMax;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // try out all ranges for that day
        for (int i = pos; i < jobDifficulty.length - day; i++) {
            max = Math.max(max, jobDifficulty[i]);
            min = Math.min(min, max + dfs(jobDifficulty, day - 1, i + 1));
        }
        return min;
    }
}
