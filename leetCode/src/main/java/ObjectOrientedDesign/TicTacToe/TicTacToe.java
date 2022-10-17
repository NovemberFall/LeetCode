package ObjectOrientedDesign.TicTacToe;

public class TicTacToe {
    int size;
    int [] rows;
    int [] cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        size = n;
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }

    public int move(int row, int col, int player) {
        int playerId = player == 1 ? 1 : -1;
        if (row == col) {
            diagonal += playerId;
            if (diagonal == size || diagonal == -size) {
                return player;
            }
        }

        if (row + col + 1 == size) {
            antiDiagonal += playerId;
            if (antiDiagonal == size || antiDiagonal == -size) {
                return player;
            }
        }

        rows[row] += playerId;
        cols[col] += playerId;
        if (rows[row] == size || rows[row] == -size || cols[col] == size || cols[col] == -size) {
            return player;
        }
        return 0;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.move(0, 0, 1); // return 0 (no one wins)
        ticTacToe.move(0, 2, 2); // return 0 (no one wins)
        ticTacToe.move(2, 2, 1); // return 0 (no one wins)
        ticTacToe.move(1, 1, 2); // return 0 (no one wins)
        ticTacToe.move(2, 0, 1); // return 0 (no one wins)
        ticTacToe.move(1, 0, 2); // return 0 (no one wins)
        System.out.println(ticTacToe.move(2, 1, 1)); // return 1 (player 1 wins)
    }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
