package DynamicProgramming._140_WordBreak_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class word_Break_II_dfs {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        dfs(s, new StringBuilder(), res, dict, 0);
        return res;
    }

    private void dfs(String s, StringBuilder sb,  List<String> res,  Set<String> wordDict, int index) {
        if (index == s.length()) {
            res.add(sb.toString());
            return;
        }

        int len = sb.length();
        for (String word : wordDict) {
            if (index + word.length() > s.length()) {
                continue;
            }
            if (s.substring(index, index + word.length()).equals(word)) {
                if (sb.isEmpty()) {
                    sb.append(word);
                } else {
                    sb.append(" " + word);
                }
                dfs(s, sb, res, wordDict, index + word.length());
                sb.setLength(len);
            }
        }
    }
}
