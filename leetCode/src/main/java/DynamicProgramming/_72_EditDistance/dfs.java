package DynamicProgramming._72_EditDistance;

class dfs {
    private String word1, word2;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        // Check what the distance is if the charaxters[0] are identical and we do nothing first
        if (word1.charAt(i) == word2.charAt(j)) {
            int nothing = dfs(i + 1, j + 1);
            return nothing;
        }

        // 1. Cost if we inserted
        int insert = 1 + dfs(i, j + 1);

        // 2. Cost if we deleted
        int delete = 1 + dfs(i + 1, j);

        // 3. Cost if we replaced
        int replace = 1 + dfs()
    }
}
