package Matrix._200_NumOfIslands;

public class numOfIslands_v2 {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';

        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        int res = numIslands(grid);
        System.out.println(res);
    }
}
