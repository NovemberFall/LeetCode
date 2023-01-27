package DFS;

import java.util.ArrayList;
import java.util.List;

/*
    Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
    You may return the answer in any order.

                        [1        2       3        4]

                      1 /        2/        3\      4\

               [2  3  4]      [3, 4]       [4]     []

         2/     3/    4\      3/   4\       4\

      [1,2]   [1,3]   [1,4]   [2,3]  [2,4]   [3,4]

 */
public class _77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> combine, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }

        for (int i = start; i <= n; i++) {
            combine.add(i);
            dfs(res, combine, i + 1, n, k - 1);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        _77_Combinations combinations = new _77_Combinations();
        List<List<Integer>> res = combinations.combine(n, k);
        System.out.println(res);
    }
}
