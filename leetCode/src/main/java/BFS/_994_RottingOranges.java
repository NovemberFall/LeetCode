package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

class _994_RottingOranges {
    // directions
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        //count, represent all fresh oranges
        int fresh = 0;

        //traverse 2d array, find out all fresh and rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // count all fresh oranges
                    fresh++;
                } else if (grid[i][j] == 2){
                    //push rotten oranges into queue
                    queue.offer(new int[]{i, j});
                }
            }
        }

        //minute, represent the number of minute
        int minute = 0;

        // if there are still fresh oranges left, and queue is not empty
        // when fresh_count == 0, you still added this last rotted orange position to the queue,
        // so there would be one more while loop that increments count by one more.
        while (fresh > 0 && !queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : dirs) {
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];
                    if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 2 ||
                            grid[row][col] == 0) {
                        continue;
                    }
                    grid[row][col] = 2;
                    fresh--;
                    queue.offer(new int[]{row, col});
                }
            }

            // BFS layer + 1
            minute++;
        }

        return fresh > 0 ? -1 : minute;
    }
}
