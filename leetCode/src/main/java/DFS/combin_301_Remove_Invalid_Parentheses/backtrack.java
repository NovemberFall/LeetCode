package DFS.combin_301_Remove_Invalid_Parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class backtrack {
    Set<String> set = new HashSet<>();
    int n, max, len;
    String s;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        n = s.length();
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else {
                r++;
            }
        }
        max = Math.min(l, r);
        dfs(0, new StringBuilder(), 0);
        return new ArrayList<>(set);
    }

    private void dfs(int index, StringBuilder curStr, int score) {
        if (score < 0 || score > max) {
            return;
        }
        if (index == n) {
            if (score == 0 && curStr.length() >= len) {
                if (curStr.length() > len) {
                    set.clear();
                }
                len = curStr.length();
                set.add(curStr.toString());
            }
            return;
        }
        char c = this.s.charAt(index);
        int tmpLen = curStr.length();
        if (c == '(') {
            dfs(index + 1, curStr, score); // not use '('
            dfs(index + 1, curStr.append(c), score + 1); // use '('
        } else if (c == ')') {
            dfs(index + 1, curStr, score); // not use ')'
            dfs(index + 1, curStr.append(c), score - 1); // use ')'
        } else {
            dfs(index + 1, curStr.append(c), score); // append a letter
        }
        curStr.setLength(tmpLen);
    }
}
