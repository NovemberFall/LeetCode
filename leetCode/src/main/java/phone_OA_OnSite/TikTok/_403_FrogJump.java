package phone_OA_OnSite.TikTok;

class _403_FrogJump {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j >= 0; j--) {
//                System.out.print("index i: " + i + "   " + "index j: " + j + " :  ");
                int k = stones[i] - stones[j];
//                System.out.print("stones[i]: " + stones[i] + " ");
//                System.out.print("stones[j]: " + stones[j] + " ");
//                System.out.print("  => k = stones[i] - stones[j] = "+ k + " ");
//                System.out.println();
                if (k > j + 1) {
//                    System.out.println("k > j + 1  => k = "+ k);
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
