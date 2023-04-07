package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

class _120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] dp = new int[rows + 1];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        _120_Triangle triangle = new _120_Triangle();
        int res = triangle.minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        ));
        System.out.println(res); // 11
    }
}
