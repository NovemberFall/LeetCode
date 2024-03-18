package DFS;

import java.util.ArrayList;
import java.util.List;

class _51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(res, 0, n, board);
        return res;
    }

    private void dfs(List<List<String>> res, int rowIndex, int n, char[][] board) {
        if (rowIndex == n) {
            List<String> tmp = new ArrayList<>();
            for (char[] c : board) {
                tmp.add(String.valueOf(c));
            }
            res.add(tmp);
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
        for (int i = 0; i < rowIndex; i++) {
            if (board[i][colIndex] == 'Q') {
                return false;
            }
        }

        // check mainDiagonal
        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check subDiagonal
        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < n ; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _51_NQueens nQueens = new _51_NQueens();
        List<List<String>> res = nQueens.solveNQueens(6);
        nQueens.print(res);
    }

    public void print(List<List<String>> res) {
        for (List<String> e : res) {
            for (String str : e) {
                for (char c : str.toCharArray()) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
