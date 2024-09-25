package Math._54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

class spiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return res;
            }

            int top = 0;
            int bottom = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;

            while (top <= bottom && left <= right) {
                // Traverse from left to right along the top row
                if (top <= bottom) {
                    for (int i = left; i <= right; i++) {
                        res.add(matrix[top][i]);
                    }
                }
                top++;  // Move the top boundary down

                // Traverse from top to bottom along the right column
                if (left <= right) {
                    for (int i = top; i <= bottom; i++) {
                        res.add(matrix[i][right]);
                    }
                }
                right--;  // Move the right boundary left

                // Traverse from right to left along the bottom row
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        res.add(matrix[bottom][i]);
                    }
                }
                bottom--;  // Move the bottom boundary up

                // Traverse from bottom to top along the left column
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        res.add(matrix[i][left]);
                    }
                }
                left++;  // Move the left boundary right
            }

            return res;
        }
    }
}
