package DFS._47_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
                            [1,1,2]
                            used[0,0,0]
                 1/            1|               2\
                {1}           `cut`              {2}
           used[1,0,0]                           used[0,0,1]
        1/              2\                    1/                1\ # cut
       {1,1}            {1,2}                {2,1}              {2,1}
     used[1,1,0]     used[1,0,1]           used[1,0,1]          used[0,1,1]
      2|                 1|                   1|
     {1,1,2}           {1,2,1}               {2,1,1}
 */
public class Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
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
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;
            dfs(res, path, nums, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
