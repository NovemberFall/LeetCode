package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

class _542_01_Matrix {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                } else {
                    mat[r][c] = -1; // Marked as not processed yet!
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row < 0 || row >= m || col < 0 || col >= n || mat[row][col] != -1) {
                    continue;
                }
                mat[row][col] = mat[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{row, col});
            }
        }
        return mat;
    }
}
