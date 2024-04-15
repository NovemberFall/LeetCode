package Math;

public class _48_RotateImage {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int s = 0, e = matrix.length - 1;
        while (s < e) {
            int[] tmp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = tmp;
            s++;
            e--;
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
