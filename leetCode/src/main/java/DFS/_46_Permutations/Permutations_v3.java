package DFS._46_Permutations;

import java.util.ArrayList;
import java.util.List;

/*
                               [1,2,3]
                 1/               |2                 \3
                [1]              [2]                 [3]
          2/       3\         1/     3\           1/     2\
       [1,2]     [1,3]      [2,1]    [2,3]       [3,1]    [3,2]
         3|        2|         3|        1|        2|         1|
       [1,2,3]   [1,3,2]    [2,1,3]  [2,3,1]     [3,1,2]    [3,2,1]
 */
class Permutations_v3 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        dfs(res, new ArrayList<>(), nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            dfs(res, path, nums);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations_v3 pvf = new Permutations_v3();
        List<List<Integer>> res = pvf.permute(nums);
        System.out.println(res);
    }
}
