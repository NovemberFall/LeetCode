package DFS._37_SudokuSolver;

public class SudokuSolver_hashSet {
    public void solveSudoku(char[][] board) {
        doSolve(board);
    }

    private boolean doSolve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if ()
                        }
                    }
                }
            }
        }
    }
}
