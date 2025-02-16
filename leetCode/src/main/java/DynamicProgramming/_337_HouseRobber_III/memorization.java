package DynamicProgramming._337_HouseRobber_III;

import java.util.HashMap;
import java.util.Map;

class memorization {
    public int rob(TreeNode root) {
        return dfs(root, new HashMap<>());
    }

    private int dfs(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return 0;

        if (memo.containsKey(root)) return memo.get(root);

        int amount = 0;
        if (root.left != null) {
            amount += dfs(root.left.left, memo) + dfs(root.left.right, memo);
        }
        if (root.right != null) {
            amount += dfs(root.right.left, memo) + dfs(root.right.right, memo);
        }
        amount = Math.max(amount + root.val, dfs(root.left, memo) + dfs(root.right, memo));
        memo.put(root, amount);
        return amount;
    }
}
