package Graph;

import java.util.PriorityQueue;

class _778_Swim_in_RisingWater {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);

        minHeap.offer(new int[]{0, 0});
        int level = 0;

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            level = Math.max(level, grid[cur[0]][cur[1]]);
            if (cur[0] == n - 1 && cur[1] == n - 1) {
                break;
            }
            System.out.println(level);
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col]) {
                    continue;
                }
                visited[cur[0]][cur[1]] = true;
                minHeap.offer(new int[]{row, col});
            }
        }
        return level;
    }

    public static void main(String[] args) {
        _778_Swim_in_RisingWater dijkstra = new _778_Swim_in_RisingWater();
        int[][] grid = new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {2, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 25}};
        int res = dijkstra.swimInWater(grid);
        System.out.println(res);
    }
}
