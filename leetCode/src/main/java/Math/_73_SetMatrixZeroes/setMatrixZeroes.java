package Math._73_SetMatrixZeroes;

import java.util.HashSet;
import java.util.Set;

class setMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }

        for (int r : rows) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = 0;
            }
        }

        for (int c : cols) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][c] = 0;
            }
        }
    }
}
