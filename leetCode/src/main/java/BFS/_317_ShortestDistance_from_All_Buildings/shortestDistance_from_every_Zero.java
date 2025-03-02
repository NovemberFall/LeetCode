package BFS._317_ShortestDistance_from_All_Buildings;

import java.util.ArrayDeque;
import java.util.Queue;

class shortestDistance_from_every_Zero {
    public int shortestDistance(int[][] grid) {
        int minDistance = Integer.MAX_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        int totalHouses = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    totalHouses++;
                }
            }
        }

        // Find the min distance sum for each empty cell.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    minDistance = Math.min(minDistance, bfs(grid, i, j, totalHouses));
                }
            }
        }

        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return minDistance;
    }

    private int bfs(int[][] grid, int row, int col, int totalHouses) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int rows = grid.length, cols = grid[0].length;
        int distanceSum = 0;
        int housesReached = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});

        // Keep track of visited cells.
        boolean[][] visited = new boolean[rows][cols];
        visited[row][col] = true;

        int steps = 0;
        while (!queue.isEmpty() && housesReached < totalHouses) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                row = cur[0];
                col = cur[1];

                // If this cell is a house, then add the distance from source to this cell
                // and we go past from this cell.
                if (grid[row][col] == 1) {
                    distanceSum += steps;
                    housesReached++;
                    continue;
                }
                // This cell was empty cell, hence traverse the next cells which is not a blockage.
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                        continue;
                    }
                    if (!visited[newRow][newCol] && grid[newRow][newCol] != 2) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            // After traversing one level of cells, increment the steps by 1 to reach to next level.
            steps++;
        }

        // If we did not reach all houses, then any cell visited also cannot reach all houses.
        // Set all cells visted to 2 so we do not check them again and return MAX_VALUE.
        if (housesReached != totalHouses) {
            for (row = 0; row < rows; row++) {
                for (col = 0; col < cols; col++) {
                    if (grid[row][col] == 0 && visited[row][col]) {
                        grid[row][col] = 2;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }

        return distanceSum;
    }
}
