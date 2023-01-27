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
class Permutations_Final {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        boolean[] visited = new boolean[nums.length];
        dfs(res, new ArrayList<>(), nums, visited);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(res, path, nums, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations_Final pvf = new Permutations_Final();
        List<List<Integer>> res = pvf.permute(nums);
        System.out.println(res);
    }
}
