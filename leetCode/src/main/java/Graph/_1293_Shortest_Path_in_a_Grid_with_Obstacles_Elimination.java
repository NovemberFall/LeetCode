package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
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

        // Queue for BFS: stores {row, col, remaining_k}
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, k});

        // Visited array: visited[r][c] stores the maximum remaining_k when reaching cell (r, c)
        // Initialize with -1 to indicate not visited with only k
        int[][] visited = new int[m][n];
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }
        visited[0][0] = k; // Start at (0,0) with k eliminations allowed
        int steps = 0; // num of steps taken

        // BFS traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Process all states at the current level (smae num of steps)
            for (int i = 0; i < levelSize; i++) {
                 int[] cur = queue.poll();
                 int row = cur[0];
                 int col = cur[1];
                 int curK = cur[2];

                // If we reached the target cell
                if (row == m - 1 && col == n - 1) {
                    return steps; //  Return the cur num of steps
                }
                // Explore neighbors
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Check if the neighbor is within grid bounds
                    if (newRow < 0 ||newRow >= m || newCol < 0 || newCol >= n) {
                        continue;
                    }
                    int obstacle = grid[newRow][newCol];
                    int remaining_K = curK - obstacle; // Remaining k after potetially eliminating an obstacle

                    // If we have enough k to eliminate the obstacle (or it's empty)
                    // AND we haven't visited this cell (newRow, newCol) with a better or equal remaining_k
                    if (remaining_K >= 0 && remaining_K > visited[newRow][newCol]) {

                    }
                }
            }
        }
    }
}
