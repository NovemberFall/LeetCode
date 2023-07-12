package BinaryTree;

public class _236_LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else if (left != null && right != null) {
            return root;
        }

        return null; // left == null && right == null
    }
}
