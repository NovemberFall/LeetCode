package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class _863_All_NodesDistance_K_in_BinaryTree {
    Map<TreeNode, TreeNode> pMap;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        pMap = new HashMap<TreeNode, TreeNode>();
        addParent(root, null);

        List<Integer> res = new ArrayList<Integer>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        dfs(target, res, visited, k);
        return res;
    }

    private void addParent(TreeNode cur, TreeNode parent) {
        if (cur == null) {
            return;
        }
        this.pMap.put(cur, parent);
        addParent(cur.left, cur);
        addParent(cur.right, cur);
    }

    private void dfs(TreeNode cur, List<Integer> res, Set<TreeNode> visited, int distance) {
        if (cur == null) {
            return;
        }
        if (visited.contains(cur)) {
            return;
        }
        visited.add(cur);
        if (distance == 0) {
            res.add(cur.val);
        }
        dfs(this.pMap.get(cur), res, visited, distance - 1);
        dfs(cur.left, res, visited, distance - 1);
        dfs(cur.right, res, visited, distance - 1);
    }
}
