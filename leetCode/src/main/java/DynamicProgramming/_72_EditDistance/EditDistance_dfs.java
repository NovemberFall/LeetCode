package DynamicProgramming._72_EditDistance;

class EditDistance_dfs {
    public int minDistance(String word1, String word2) {
        // base case
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();

        // a. Check what the distance is if the charaxters[0] are identical and we do nothing first
        if (word1.charAt(0) == word2.charAt(0)) {
            int nothing = minDistance(word1.substring(1), word2.substring(1));
            return nothing;
        }

        // b. chech what the distance is if we do a Replace first?
        int replace = 1 + minDistance(word1.substring(1),
                word2.substring(1));

        // c. check what the distance is if we do a Delete first?
        int delete = 1 + minDistance(word1.substring(1), word2);

        // d. chech what the distance is if we do a Insert first?
        int insert = 1 + minDistance(word1, word2.substring(1));

        return Math.min(delete, Math.min(replace, insert));
    }
}
