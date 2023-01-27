package DFS._90_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
                         [1, 2, 2]

               1/            2|           2\

             [2, 2]          [2]
             {1}             {2}

           2/      2\         2|

         [2]                  {2, 2}
         {1, 2}

        /
      {1, 2, 2}
 */
class Subsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), 0, used, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> subset, int startIdx, boolean[] used, int[] nums) {
        res.add(new ArrayList<>(subset));
        for (int i = startIdx; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            used[i] = true;
            dfs(res, subset, i + 1, used, nums);
            used[i] = false;
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Subsets subsets = new Subsets();
        List<List<Integer>> res = subsets.subsetsWithDup(nums);
        System.out.println(res);
    }
}
