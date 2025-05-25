package DFS.subset_113_PathSum_II;

import java.util.ArrayList;
import java.util.List;

class dfs {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), root, targetSum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        } else {
            dfs(res, path, root.left, targetSum);
            dfs(res, path, root.right, targetSum);
        }
        path.remove(path.size() - 1);
    }
}
