package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

class _1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // If k is large enough, the shortest path is just Manhattan distance
        if (k >= m + n - 2) {
            return m + n - 2;
        }

        // visited[r][c][kLeft] = true means we've been at (r,c) with kLeft eliminations remaining.
        // This 3D array tracks visited states to avoid cycles and redundant processing.
        boolean[][][] visited = new boolean[m][n][k + 1];

        // Queue for BFS: stores {row, col, remaining_k}
        Queue<int[]> queue = new ArrayDeque<>();
        // Queue stores {row, col, steps, remaining_k}
        queue.offer(new int[]{0, 0, 0, k});
        visited[0][0][k] = true; // Mark the starting state as visited

        // BFS traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Process all states at the current level (smae num of steps)
            for (int i = 0; i < levelSize; i++) {
                 int[] cur = queue.poll();
                 int row = cur[0];
                 int col = cur[1];
                 int steps = cur[2];
                 int kLeft = cur[3];

                // If we reached the target cell
                if (row == m - 1 && col == n - 1) {
                    return steps; //  Return the cur num of steps
                }
                // Explore neighbors
                for (int[] dir : dirs) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    // Check if the neighbor is within grid bounds
                    if (nr < 0 ||nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Calculate remaining k after potentially eliminating an obstacle at (nr, nc)
                    int nextK = kLeft - grid[nr][nc];
                    // If we have enough eliminations left (nextK >= 0)
                    // AND this exact state (row, col, remainingK) hasn't been visited
                    if (nextK >= 0 && !visited[nr][nc][nextK]) {
                        visited[nr][nc][nextK] = true;
                        queue.offer(new int[]{nr, nc, steps + 1, nextK});
                    }
                }
            }
            // After processing all nodes at the current level, the next iteration
            // of the while loop will process nodes at the next level (steps + 1).
        }
        // If the queue is empty and the destination hasn't been reached, no path exists
        return -1;
    }
}
