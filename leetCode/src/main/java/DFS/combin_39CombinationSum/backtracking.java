package DFS.combin_39CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backtracking {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(res, new ArrayList<>(), 0, candidates, target);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> combine,
                     int startIdx, int[] candidates, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            combine.add(candidates[i]);
            dfs(res, combine, i, candidates, target - candidates[i]);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        backtracking combinationSum = new backtracking();
        List<List<Integer>> res = combinationSum.combinationSum(candidates, 7);
        System.out.println(res);
        int[] candidates2 = {2, 3, 5};
        res = combinationSum.combinationSum(candidates2, 8);
        System.out.println(res);
//        [[2, 2, 3], [7]]
//        [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    }
}
