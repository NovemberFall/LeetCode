package DFS;

public class _52_NQueens_II {
    public int totalNQueens(int n) {
        int[] res = new int[]{0};
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(res, 0, n, board);
        return res[0];
    }

    private void dfs(int[] res, int rowIndex, int n, char[][] board) {
        if (rowIndex == n) {
            res[0]++;
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (isValid(rowIndex, colIndex, n, board)) {
                board[rowIndex][colIndex] = 'Q';
                dfs(res, rowIndex + 1, n, board);
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    private boolean isValid(int rowIndex, int colIndex, int n, char[][] board) {
        for (int i = 0; i < n; i++) {
            if (board[i][colIndex] == 'Q') {
                return false;
            }
        }

        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _52_NQueens_II nQueens_ii = new _52_NQueens_II();
        int res = nQueens_ii.totalNQueens(6);
        System.out.println(res); // 4
    }
}
