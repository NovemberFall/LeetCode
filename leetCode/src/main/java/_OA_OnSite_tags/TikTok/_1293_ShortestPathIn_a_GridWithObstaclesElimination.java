package _OA_OnSite_tags.TikTok;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class _1293_ShortestPathIn_a_GridWithObstaclesElimination {
    private int[][] dirs = {
            {0, 1}, {0, -1},
            {1, 0}, {-1, 0}
    };

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] seen = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }
        seen[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        // Updated on 22 July 2021
        // we do not use to save 3 elements, only 2 are enough
        // thanks for @rishi-lgtm!
        // https://github.com/happygirlzt/algorithm-illustrations/issues/1
        q.offer(new int[]{0, 0});

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int row = cur[0], col = cur[1];
                if (row == m - 1 && col == n - 1) return steps;

                for (int[] d : dirs) {
                    int r = row + d[0], c = col + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        int o = grid[r][c] + seen[row][col];
                        System.out.println("seen[row][col]: " + seen[row][col] + "  seen[r][c]: " + seen[r][c] + "  obstacle: " +o);
                        if (o >= seen[r][c] || o > k) continue;

                        seen[r][c] = o;
                        q.offer(new int[]{r, c});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
