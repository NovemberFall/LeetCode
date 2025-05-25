package DFS.subset_78_Subsets;

import java.util.ArrayList;
import java.util.List;

class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> subset, int startIndex, int[] nums) {
        res.add(new ArrayList<>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(res, subset, i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        _78_Subsets subset = new _78_Subsets();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = subset.subsets(nums);
        System.out.println(res);
    }
}
