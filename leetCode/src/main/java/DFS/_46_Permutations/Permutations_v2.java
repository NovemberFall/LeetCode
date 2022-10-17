package DFS._46_Permutations;

import java.util.ArrayList;
import java.util.List;

class Permutations_v2 {
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

        path.add(nums[0]);
        dfs(res, path, nums);
        path.remove(path.size() - 1);

        path.add(nums[1]);
        dfs(res, path, nums);
        path.remove(path.size() - 1);

        path.add(nums[2]);
        dfs(res, path, nums);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations_v2 pv2 = new Permutations_v2();
        List<List<Integer>> res = pv2.permute(nums);
        System.out.println(res);
    }
}