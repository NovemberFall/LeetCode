package Math._902_Numbers_At_Most_N_Given_Digit_Set;

import java.util.ArrayList;
import java.util.List;

class dfs {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        List<Integer> res = new ArrayList<>();
        char[] s = Integer.toString(n).toCharArray();
        dfs(res, s, 0, 0, true);
        return res.size();
    }

    private void dfs(List<Integer> res, char[] s, int index, int path, boolean isLimit) {
        if (index == s.length) {
            res.add(path);
            return;
        }
        int up = isLimit ? s[index] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            dfs(res, s, index + 1, path * 10 + d, isLimit && d == up);
        }
    }
}
