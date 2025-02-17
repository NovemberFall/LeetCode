package Math._59_Spiral_Matrix_II;

class spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        recursive(matrix, 0, n, 1);
        return matrix;
    }

    private void recursive(int[][] res, int offset, int size, int counter) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            res[offset][offset] = counter;
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            res[offset][offset + i] = counter;
            counter++;
        }
        for (int i = 0; i < size - 1; i++) {
            res[offset + i][offset + size - 1] = counter;
            counter++;
        }
        for (int i = size - 1; i >= 1; i--) {
            res[offset + size - 1][offset + i] = counter;
            counter++;
        }
        for (int i = size - 1; i >= 1; i--) {
            res[offset + i][offset] = counter;
            counter++;
        }

        recursive(res, offset + 1, size - 2, counter);
    }
}
