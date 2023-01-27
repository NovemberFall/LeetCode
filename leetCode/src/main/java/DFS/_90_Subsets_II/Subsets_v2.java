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
class Subsets_v2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> subset, int startIdx, int[] nums) {
        res.add(new ArrayList<>(subset));
        for (int i = startIdx; i < nums.length; i++) {
            if (i > startIdx && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            dfs(res, subset, i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Subsets_v2 subsets = new Subsets_v2();
        List<List<Integer>> res = subsets.subsetsWithDup(nums);
        System.out.println(res);
    }
}
