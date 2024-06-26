package Math._73_SetMatrixZeroes;

class SetMatrixZeroes_O1 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean rowZero = false, columnZero = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        rowZero = true;
                    }
                    if (j == 0) {
                        columnZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j]  = 0;
            }
        }
        if (columnZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0]  = 0;
            }
        }
    }
}
