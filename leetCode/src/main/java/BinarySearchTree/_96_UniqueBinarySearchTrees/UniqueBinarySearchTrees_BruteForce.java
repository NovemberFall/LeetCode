package BinarySearchTree._96_UniqueBinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

class UniqueBinarySearchTrees_BruteForce {
    public int numTrees(int n) {
        if (n == 0) return 0;

        List<TreeNode> res = recursion(1, n);
        return res.size();
    }

    private List<TreeNode> recursion(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtree = recursion(start, i - 1);
            List<TreeNode> rightSubtree = recursion(i + 1, end);
            for (TreeNode leftNode : leftSubtree) {
                for (TreeNode rightNode : rightSubtree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
