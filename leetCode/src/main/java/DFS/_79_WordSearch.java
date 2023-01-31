package DFS;

public class _79_WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean checked = dfs(board, i, j, word, 0, visited);
                if (checked) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        boolean found = dfs(board, i + 1, j, word, index + 1, visited) ||
                dfs(board, i, j + 1, word, index + 1, visited) ||
                dfs(board, i - 1, j, word, index + 1, visited) ||
                dfs(board, i, j - 1, word, index + 1, visited);
        visited[i][j] = false;
        return found;
    }

    public static void main(String[] args) {
        _79_WordSearch wordSearch = new _79_WordSearch();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean res = wordSearch.exist(board, "SEE");
        System.out.println(res);
    }
}
