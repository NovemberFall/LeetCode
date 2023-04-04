package Monotonic_Stack._85_MaximalRectangle;

import java.util.Stack;

class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length, cols = matrix[0].length;
        int[][] histogram = new int[rows][cols];
        buildHistogram(matrix, histogram);

        int max = 0;
        for (int i = 0; i < rows; i++) {
            max = Math.max(max, maxRec(histogram, i));
        }
        return max;
    }

    private void buildHistogram(char[][] matrix, int[][] histogram) {
        for (int j = 0; j < matrix[0].length; j++) {
            histogram[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                histogram[i][j] = matrix[i][j] == '1' ? histogram[i - 1][j] + 1 : 0;
            }
        }
    }

    private int maxRec(int[][] histogram, int row) {
        Stack<Integer> stk = new Stack<>();

        int areaWithTop;
        int maxArea = -1;
        int curIndex = 0;
        while (curIndex < histogram[row].length) {
            if (stk.isEmpty() || histogram[row][stk.peek()] <= histogram[row][curIndex]) {
                stk.push(curIndex);
                curIndex++;
            } else {
                int temp = stk.pop();
                if (stk.isEmpty()) {
                    areaWithTop = histogram[row][temp] * curIndex;
                } else {
                    areaWithTop = histogram[row][temp] * (curIndex - stk.peek() - 1);
                }
                maxArea = Math.max(maxArea, areaWithTop);
            }
        }

        while (!stk.isEmpty()) {
            int temp = stk.pop();
            if (stk.isEmpty()) {
                areaWithTop = histogram[row][temp] * curIndex;
            } else {
                areaWithTop = histogram[row][temp] * (curIndex - stk.peek() - 1);
            }
            maxArea = Math.max(maxArea, areaWithTop);
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
