package Matrix._130_SurroundedRegions;

class surroundedRegions_v2 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, visited, false);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1, visited, false);
            }
        }

        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, visited, false);
            }
            if (board[rows - 1][i] == 'O') {
                dfs(board, rows - 1, i, visited, false);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, i, j, visited, true);
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col, boolean[][] visited, boolean flip) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        if (board[row][col] == 'X') {
            return;
        }
        if (flip) {
            board[row][col] = 'X';
        }

        visited[row][col] = true;
        dfs(board, row + 1, col, visited, flip);
        dfs(board, row, col + 1, visited, flip);
        dfs(board, row - 1, col, visited, flip);
        dfs(board, row, col - 1, visited, flip);
    }
}
