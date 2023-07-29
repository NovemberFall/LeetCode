package DFS._17_LetterCombinations_of_aPhoneNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(res, new StringBuilder(), digits, map, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String digits, String[] map, int index) {
        if (index == digits.length()) {
            res.add(new String(sb));
            return;
        }

        String curStr = map[digits.charAt(index) - '0'];
        for (int i = 0; i < curStr.length(); i++) {
            sb.append(curStr.charAt(i));
            dfs(res, sb, digits, map, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution soln = new Solution();
        List<String> res = soln.letterCombinations("23");
        System.out.println(res); // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
