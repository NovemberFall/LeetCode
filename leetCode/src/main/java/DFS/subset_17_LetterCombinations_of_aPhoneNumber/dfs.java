package DFS.subset_17_LetterCombinations_of_aPhoneNumber;

import java.util.ArrayList;
import java.util.List;

class dfs {
    final String[] MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        char[] path = new char[digits.length()];
        dfs(digits, res, path, 0);
        return res;
    }

    private void dfs(String digits, List<String> res, char[] path, int index) {
        if (index == digits.length()) {
            res.add(new String(path));
            return;
        }

        char digit = digits.charAt(index);
        String letters = MAP[digit - '0'];
        for (char c : letters.toCharArray()) {
            path[index] = c;  // 直接覆盖
            dfs(digits, res, path, index + 1);
        }
    }
}
