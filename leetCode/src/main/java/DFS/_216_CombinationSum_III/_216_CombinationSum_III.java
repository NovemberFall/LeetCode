package DFS._216_CombinationSum_III;

import java.util.ArrayList;
import java.util.List;

class _216_CombinationSum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int n, int startIndex) {
        if (list.size() == k) {
            int total = 0;
            for (Integer i : list) {
                total += i;
            }
            if (total == n) {
                res.add(new ArrayList<>(list));
                return;
            }
        }

        for (int i = startIndex; i <= 9; i++) {
            list.add(i);
            dfs(res, list, k, n, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
