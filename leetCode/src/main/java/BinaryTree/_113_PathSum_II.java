package BinaryTree;

import java.util.ArrayList;
import java.util.List;

class _113_PathSum_II {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, new ArrayList<>(), root, targetSum);
        return res;
    }

    private void dfs(List<List<Integer>> res,
                     List<Integer> pathSum, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        pathSum.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(pathSum));
        }
        dfs(res, pathSum, root.left, targetSum - root.val);
        dfs(res, pathSum, root.right, targetSum - root.val);
        pathSum.remove(pathSum.size() - 1);
    }
}
