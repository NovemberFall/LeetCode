package DynamicProgramming._44_WildcardMatching;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class wildcardMatching_memo {
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> dp = new HashMap<>();
        String clean_p = remove_duplicate_stars(p);
        return dfs(s, clean_p, dp, 0, 0);
    }

    private String remove_duplicate_stars(String p) {
        StringBuilder sb = new StringBuilder();
        for (char c : p.toCharArray()) {
            if (sb.length() == 0) {// If StringBuilder is empty, just append the character
                sb.append(c);
                continue;
            }
            // Get the last character in the StringBuilder
            char lastChar = sb.charAt(sb.length() - 1);

            // If the current character is not '*', append it
            if (c != '*') {
                sb.append(c);
            }
            // If the current character is '*', check the last character
            else if (lastChar != '*') {
                // Append '*' only if the last character is not also '*'
                sb.append(c);
            }
            // If the last character is already '*', do nothing (skip duplicate)
        }
        return sb.toString();
    }

    private boolean dfs(String s, String cleanP, Map<String, Boolean> dp, int sidx, int pidx) {
        String key = sidx + "," + pidx;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (pidx == cleanP.length()) {
            dp.put(key, sidx == s.length());
        } else if (sidx == s.length()) {
            dp.put(key, pidx + 1 == cleanP.length() && cleanP.charAt(pidx) == '*');
        } else if (cleanP.charAt(pidx) == s.charAt(sidx) || cleanP.charAt(pidx) == '?') {
            dp.put(key, dfs(s, cleanP, dp, sidx + 1, pidx + 1));
        } else if (cleanP.charAt(pidx) == '*') {
            // Case 1: '*' matches zero characters, empty string
            boolean matchZero = dfs(s, cleanP, dp, sidx, pidx + 1);
            // Case 2: '*' matches at least one character
            boolean matchOneOrMore = dfs(s, cleanP, dp, sidx + 1, pidx);
            dp.put(key, matchZero || matchOneOrMore);

            // dp.put(key, dfs(s, cleanP, dp, sidx, pidx + 1) || dfs(s, cleanP, dp, sidx + 1, pidx));
        } else if (cleanP.charAt(pidx) != s.charAt(sidx)) {
            dp.put(key, false);
        }
        return dp.get(key);
    }

    @Test
    public void test_remove_duplicate_stars_method() {
        String s = "**a**b***c*";
        String clean_s = remove_duplicate_stars(s);
        System.out.println(clean_s);
    }
}





