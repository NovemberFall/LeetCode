package DFS.combin_216_CombinationSum_III;

import java.util.ArrayList;
import java.util.List;

class CombinationSum_III_v2 {
    int total;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.total = n;
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int startIndex, int targetSum, int k) {
        if (targetSum < 0) {
            return;
        }

        if (list.size() == k && targetSum == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = startIndex; i <= Math.min(9, this.total); i++) {
            list.add(i);
            dfs(res, list, i + 1, targetSum - i, k);
            list.remove(list.size() - 1);
        }
    }
}
