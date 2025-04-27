package DynamicProgramming._72_EditDistance;

class dfs_with_TLE {
    private String word1, word2;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        // Base cases: if one string is finished,
        // the cost is to insert/delete the rest of the other string
        if (i == word1.length()) {
            return word2.length() - j;  // insert remaining chars of word2
        }
        if (j == word2.length()) {
            return word1.length() - i;  // delete remaining chars of word1
        }

        // If the current characters match
        if (word1.charAt(i) == word2.charAt(j)) {
            // No operation needed for these matching characters.
            // The minimum distance is the distance of the remaining substrings.
            int nothing = dfs(i + 1, j + 1);
            return nothing;
        } else {
            // 1. Insert: Insert word2[j] into word1. This means we now need to match
            //    word1[i...end] with the rest of word2[j+1...end]. Cost is 1 + distance of remaining.
            int insert = 1 + dfs(i, j + 1);

            // 2. Delete: Delete word1[i]. This means we now need to match
            //    word1[i+1...end] with word2[j...end]. Cost is 1 + distance of remaining.
            int delete = 1 + dfs(i + 1, j);

            // 3. Replace: Replace word1[i] with word2[j]. This means we now need to match
            //    word1[i+1...end] with word2[j+1...end]. Cost is 1 + distance of remaining.
            int replace = 1 + dfs(i + 1, j + 1);

            return Math.min(insert, Math.min(delete, replace));
        }
    }
}
