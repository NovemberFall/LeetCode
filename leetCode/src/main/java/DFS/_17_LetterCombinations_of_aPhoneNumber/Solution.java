package DFS._17_LetterCombinations_of_aPhoneNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        dfs(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String digits, int mapIndex) {
        if (mapIndex == digits.length()) {
            res.add(new String(sb));
            return;
        }

        char c = digits.charAt(mapIndex);
        int pos = c - '0';
        String map_str = map[pos];
        for (int i = 0; i < map_str.length(); i++) {
            sb.append(map_str.charAt(i));
            dfs(res, sb, digits, mapIndex + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution soln = new Solution();
        List<String> res = soln.letterCombinations("23");
        System.out.println(res); // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
